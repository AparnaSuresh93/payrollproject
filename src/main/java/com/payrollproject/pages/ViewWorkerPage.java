package com.payrollproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payrollproject.utilities.PageUtility;
import com.payrollproject.utilities.WaitUtility;
import com.payrollproject.utilities.WaitUtility.LocatorType;

public class ViewWorkerPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public ViewWorkerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	@FindBy(xpath="//table[@class='table table-striped table-bordered detail-view']//tbody//tr[6]//td[1]")
	private WebElement workerFName;
	
	@FindBy(xpath="//table[@id='w0']//tbody//tr[19]//td[1]")
	private WebElement workerEmail;
	
	/*** UserActionMethods ***/
	public String getWorkersEmailTxt() {
		return PageUtility.getElementText(workerEmail);
	}

	public String getWorkerFirstName() {
		return PageUtility.getElementText(workerFName);
	}
	public void getViewTabElementVisibility()
	  {
		  WaitUtility.waitForelementVisibility(driver,workerFName , LocatorType.Xpath);
	  }
	

}
