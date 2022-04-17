package com.payrollproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payrollproject.utilities.PageUtility;
import com.payrollproject.utilities.WaitUtility;
import com.payrollproject.utilities.WaitUtility.LocatorType;

public class ResetPage {
	WebDriver driver;
	ResetPage reset;
	
	
	/*** PageConstructor ***/
	public ResetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*** WebElements ***/

	@FindBy(id ="passwordresetrequestform-email")
	private WebElement emailTextbox;

	//@FindBy(xpath ="//a[text()='reset it']")
	
	//@FindBy(xpath="//*[contains(text(),'reset it')]")
	@FindBy(linkText="reset it")
	private WebElement resetLink;
	
	@FindBy(xpath="//button[text()='Send']")
	private WebElement sendBtn;
	
	@FindBy(xpath="//a[text()='Cancel']")
	private WebElement cancelBtn;

    //@FindBy(xpath ="//p[text()='Email cannot be blank.']")
	@FindBy(xpath="//p[contains(text(),'Email cannot be blank.')]")
	private WebElement emailBlankMsg;
	
	@FindBy(xpath="//p[text()='Email is not a valid email address.']")
    private WebElement inValidemailErrorMsg;
	
	//@FindBy(xpath="//p[text()='There is no user with this email address.']")
	@FindBy(xpath="//p[contains(text(),'There is no user with this email address.')]")
	private WebElement emailErrorMsg;

/***  User Actions  ***/
	public void enterEmailTextbox(String email) {
		PageUtility.enterText(emailTextbox, email);
	}
	public void clickOnSendBtn()
	{
		PageUtility.clickOnelement(sendBtn);
	}
	public LoginPage clickOnCancelBtn()
	{
		PageUtility.clickOnelement(cancelBtn);
		return new LoginPage(driver);
	}
	public String getInvalidEmailErrorMsg()
	{
		return PageUtility.getElementText(emailErrorMsg);
	}
	public String getEmailBlankErrorMsg()
	{
		return PageUtility.getElementText(emailBlankMsg);
	}
	public String getInvalidFormatEmailMsg()
	{
		return PageUtility.getElementText(inValidemailErrorMsg);
	}
	public String pageTitle() {
		
		return PageUtility.getPageTitle(driver);
	}
	public void getIncorrectFormatEmailMsgWait()
	{
		WaitUtility.waitForelementVisibility(driver,inValidemailErrorMsg ,LocatorType.Xpath);
	}
	public void getErrorMsgDisplayWait()
	{
		WaitUtility.waitForelementVisibility(driver, emailErrorMsg,LocatorType.Xpath);
	}
	public void getBlankErrorMsgWait()
	{
		WaitUtility.waitForelementVisibility(driver,emailBlankMsg,LocatorType.Xpath);
		
	}
	
}


