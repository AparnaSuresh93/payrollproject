package com.payrollproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

import com.payrollproject.utilities.PageUtility;
import com.payrollproject.utilities.TableUtility;
import com.payrollproject.utilities.WaitUtility;
import com.payrollproject.utilities.WaitUtility.LocatorType;

public class ClientPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public ClientPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*** WebElements ***/
	@FindBy(xpath="//table[@class='table table-striped table-bordered']//tbody//tr[1]//td[1]")
	private WebElement clientId1;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']//tbody//tr[2]//td[1]")
	private WebElement clientId2;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']//tbody//tr[3]//td[1]")
	private WebElement clientId3;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']//tbody//tr[4]//td[1]")
	private WebElement clientId4;
	
	@FindBy(xpath="//div[text()='Branch cannot be blank.']")
	private WebElement reqfieldErrorMsg;
	
	@FindBy(xpath="//a[text()='Clients']")  
	private WebElement client;
	
	@FindBy(xpath="//a[text()='Create Client']")    
	private WebElement createClient;
	
	@FindBy(xpath="//a[text()='Client ID']")
	private WebElement clientId;
	
	@FindBy(xpath="//a[text()='Client Name']")
	private WebElement clientName;
	
	@FindBy(xpath="//input[@id='client-your_ref']")
	private WebElement yourRef;
	
	@FindBy(xpath="//a[text()='Client Address']")
	private WebElement clientAddress;
	
	@FindBy(xpath="//a[text()='Postcode']")
	private WebElement postCode;
	
	@FindBy(xpath="//input[@id='clientsearch-client_name']")   //@FindBy(id="clientsearch-client_name")
	private WebElement clientNameSearchTxt;
	
	@FindBy(id="clientsearch-id")
	private WebElement clientIdSearchTxt;
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//button[text()='Reset']")
	private WebElement resetBtn;
	
//	@FindBy(xpath="//a[@title='View']")
//	private WebElement eyeIconBtn;
	
	 @FindBy(xpath="//table[@class='table table-striped table-bordered']//tbody//tr[2]//td[6]//a[1]")
	 private WebElement eyeIconBtn;
	
	@FindBy(xpath="//a[@title='Update']")
	private WebElement editIconBtn;
	
	@FindBy(xpath="//a[text()='Clients']")
	private WebElement clientsTab;
	
	@FindBy(xpath="//a[@data-sort='your_ref']")
	private WebElement yourRefSortLink;
	
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']//tbody")
	private WebElement ClientTable;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']//tbody//tr")
	private List<WebElement> rElement;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']//tbody//tr//td")
	private List<WebElement> cElement;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement logoDropdown;
	
	/*** UserActionMethods  ***/
	
	public void getSoftWaitClientTab()
	{
		WaitUtility.waitForelementTobeClickable(driver,clientsTab,LocatorType.Xpath);
	}
	public void getSoftWaitResetBtnClick()
	{
		 WaitUtility.waitForelementTobeClickable(driver, resetBtn, LocatorType.Xpath);
	}
	public String getClientTitle()
	{
		return PageUtility.getPageTitle(driver);
	}
	public void clientClick()
	{
		PageUtility.clickOnelement(clientsTab);
	}
//	public void viewIconClick()
//	{
//		PageUtility.clickOnelement(eyeIconBtn);
//	}
	public void searchClientName(String name)
	{
		PageUtility.enterText(clientNameSearchTxt, name);
	}
	public void enterYourRefTxt(String text)
	{
		PageUtility.getElementClear(yourRef);
		PageUtility.enterText(yourRef,text);
	}
	public void searchClientID(String text)
	{
		PageUtility.enterText(clientIdSearchTxt, text);
	}
	public void clientSearchBtnClk()
	{
		PageUtility.clickOnelement(searchBtn);
	}
	public void clientViewBtnClkWait()
	{
		WaitUtility.waitForelementTobeClickable(driver, eyeIconBtn, LocatorType.Xpath);
	//	PageUtility.clickOnelement(eyeIconBtn);
	}
	public void clientUpdateBtnClk()
	{
		WaitUtility.waitForelementTobeClickable(driver,editIconBtn, null);
		PageUtility.clickOnelement(editIconBtn);
	}
	public void clientResetBtnClk()
	{
		PageUtility.clickOnelement(resetBtn);
	}
	public void sortByClientId()
	{
		PageUtility.clickOnelement(clientId);
	}
	public void createClientClk()
	{
		PageUtility.clickOnelement(createClient);
	}
	public void sortByClientName()
	{
		PageUtility.clickOnelement(clientName);
	}
	public void sortByYourRef()
	{
		PageUtility.clickOnelement(yourRefSortLink);
	}
	public void sortByClientAddress()
	{
		PageUtility.clickOnelement(clientAddress);
	}
	public void sortByPostCode()
	{
		PageUtility.clickOnelement(postCode);
	}
	public void waitforDisplay()
	{
		WaitUtility.implicitWaitMeth(driver);
	}
	public void waitForResetBtnDisplay()
	{
		WaitUtility.waitForelementTobeClickable(driver, resetBtn,LocatorType.Xpath);
	}
	public void waitForClientTable()
	{
		WaitUtility.waitForelementVisibility(driver, ClientTable, LocatorType.Xpath);
	}
	
	public void waitForDropdwnVisibility()
	{
		WaitUtility.waitForelementVisibility(driver,logoDropdown , LocatorType.Xpath);
	}
	
	
	
	public List<ArrayList<String>> getTableData() {
		// TODO Auto-generated method stub
	//	WaitUtility.hardWait();
		//WaitUtility.waitForElement(driver,clientTable ,LocatorType.Xpath;
		return TableUtility.gridData(rElement,cElement);
	}
	public void clickonSaveBtn() {
		// TODO Auto-generated method stub
		PageUtility.clickOnelement(saveBtn);
	}
  
	public ViewClientPage ClickonViewButton(String client) throws InterruptedException {
		List<ArrayList<WebElement>> grid=TableUtility.actionData(rElement, cElement);
		WaitUtility.hardWait();
		System.out.println(grid);
		OUTER: for(int i=0;i<grid.size();i++)
		{
			for(int j=0;j<grid.get(0).size();j++)
			{
				String data=grid.get(i).get(j).getText();
				if(data.equals(client))
				{
					WebElement eyeIconBtn=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tbody//tr["+(i+1)+"]//td[6]//a[1]"));
					PageUtility.clickOnelement(eyeIconBtn);
					break OUTER;
				}
			}
		}
		return new ViewClientPage(driver);
	}
	public UpdateClientPage ClickonUpdateButton(String client) throws InterruptedException {
		List<ArrayList<WebElement>> grid=TableUtility.actionData(rElement, cElement);
	     //WaitUtility.hardWait();
		//WaitUtility.waitForelement(driver, userstable, LocatorType.Xpath);
		WaitUtility.waitForelementTobeClickable(driver, ClientTable,LocatorType.Xpath);
		System.out.println(grid);
		OUTER: for(int i=0;i<grid.size();i++)
		{
			for(int j=0;j<grid.get(0).size();j++)
			{
				String data=grid.get(i).get(j).getText();
				if(data.equals(client))
				{
					WebElement updateBtn=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tbody//tr["+(i+1)+"]//td[6]//a[2]"));
					PageUtility.clickOnelement(updateBtn);
					break OUTER;
				}
			}
		}
		return new UpdateClientPage(driver);
	}
	
	public int sortClientIdCheck(double d,double e,double f,double g)
	{
		if(d<e  && e<f  && f<g)
		{
         String flag = "Client Id is sorted";
         return 0;
			}
		return 1;
	}
	

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


