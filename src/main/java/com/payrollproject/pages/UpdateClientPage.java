package com.payrollproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payrollproject.utilities.PageUtility;
import com.payrollproject.utilities.WaitUtility;

public class UpdateClientPage {
	WebDriver driver;

	/*** PageConstructor ***/
	public UpdateClientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*** WebElements ***/
	
	@FindBy(id="client-email")
	private WebElement email; 
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement saveBtn;
	
	/*** UserActionMethods ***/
	public void enterUpdateClientemail(String eMail)
	{
		PageUtility.getElementClear(email);
		PageUtility.enterText(email, eMail);
	}
	public ClientPage clickonSaveBtn()
	{
		PageUtility.clickOnelement(saveBtn);
		return new ClientPage(driver);
	}
//	public void getSoftWaitUpdateClientTable()
//	{
//		WaitUtility.waitForelementVisibility(driver, email, null);
//	}

}
