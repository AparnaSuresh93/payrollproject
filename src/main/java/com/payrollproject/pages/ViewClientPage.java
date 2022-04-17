package com.payrollproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payrollproject.utilities.PageUtility;
import com.payrollproject.utilities.WaitUtility;
import com.payrollproject.utilities.WaitUtility.LocatorType;

public class ViewClientPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public ViewClientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/*** WebElements ***/
	@FindBy(xpath="//table[@id='w0']//tbody//tr[3]//td[1]")
	private WebElement clientName;
 
	@FindBy(xpath="//table[@id='w0']//tbody//tr[5]//td[1]")
	private WebElement clientAddress;
	
	@FindBy(xpath="//table[@id='w0']//tbody//tr[10]//td[1]")
	private WebElement email;
	
	
	
	
	/*** UserActionMethods ***/
	
	public String getClientName() {
		return PageUtility.getElementText(clientName);
	}

	public String getClientAddress() {
		return PageUtility.getElementText(clientAddress);
	}

	public String getEmail() {
		return PageUtility.getElementText(email);
		
	}
	public void getViewTabElementVisibility()
	  {
		  WaitUtility.waitForelementVisibility(driver,clientName , LocatorType.Xpath);
	  }
	

	

}
