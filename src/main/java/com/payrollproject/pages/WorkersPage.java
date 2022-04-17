package com.payrollproject.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payrollproject.utilities.PageUtility;
import com.payrollproject.utilities.TableUtility;
import com.payrollproject.utilities.WaitUtility;
import com.payrollproject.utilities.WaitUtility.LocatorType;

public class WorkersPage {
WebDriver driver;
	
	/*** PageConstructor ***/
	public WorkersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/***   Web Elements   ***/
	 @FindBy(xpath="//input[@id='workersearch-first_name']")
	 private WebElement fName;
	 
	 @FindBy(xpath="//input[@name='WorkerSearch[last_name]']")
	 private WebElement lName;
	 
	 @FindBy(xpath="//input[@id='workersearch-postcode']")
	 private WebElement postCode;
	 
	 @FindBy(xpath="//input[@id='workersearch-ni_number']")
	 private WebElement niNumber;
	 
	 @FindBy(xpath="//button[text()='Search']")
	 private WebElement searchBtn;
	 
	 @FindBy(xpath="//button[text()='Reset']")
	 private WebElement resetBtn;
	 
	 @FindBy(linkText="Workers")
	 private WebElement workersTab;
	 
	 @FindBy(css="[title='View']")
	 private WebElement viewIcon;
	 
	 @FindBy(xpath="//table[@class='table table-striped table-bordered']")
	 private WebElement workerstable;
	 
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr")
	private List<WebElement> rElement;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr//td")
	private List<WebElement> cElement;
	 
	 
		/*** UserActionMethods  ***/
	 

		public void getSoftWaitWorkersTab()
		{
			WaitUtility.waitForelementTobeClickable(driver,workersTab,LocatorType.Xpath);
		}
	 
	 public void searchByWorkerfirstName(String name)
		{
			PageUtility.enterText(fName, name);
		}
	 public void searchByWorkerlastName(String name)
		{
			PageUtility.enterText(lName, name);
		}
	 public void searchByWorkerPostCode(String name)
		{
			PageUtility.enterText(postCode, name);
		}
	 public void searchByWorkerNiNumber(String name)
		{
			PageUtility.enterText(niNumber, name);
		}
	 public void workersSearchBtnClk()
		{
			PageUtility.clickOnelement(searchBtn);
		}
	 public void workersViewBtnClk()
		{
			PageUtility.clickOnelement(viewIcon);
		}
	 public List<ArrayList<String>> getTableData() throws InterruptedException {
			WaitUtility.hardWait();
			WaitUtility.waitForelementVisibility(driver,workerstable,LocatorType.Xpath);
			return TableUtility.gridData(rElement, cElement);

		}
	 public ViewWorkerPage ClickonViewButton(String user) throws InterruptedException {
			List<ArrayList<WebElement>> grid=TableUtility.actionData(rElement, cElement);
			WaitUtility.hardWait();
			System.out.println(grid);
			OUTER: for(int i=0;i<grid.size();i++)
			{
				for(int j=0;j<grid.get(0).size();j++)
				{
					String data=grid.get(i).get(j).getText();
					if(data.equals(user))
					{
						//WaitUtility.hardWait();
						WebElement viewbutton=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tbody//tr[1]//td[8]//a[1]"));
						PageUtility.clickOnelement(viewbutton);
						break OUTER;
					}
				}
			}
			return new ViewWorkerPage(driver);
		}

	

}
