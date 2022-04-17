package com.payrollproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payrollproject.utilities.PageUtility;
import com.payrollproject.utilities.WaitUtility;
import com.payrollproject.utilities.WaitUtility.LocatorType;

public class LoginPage {
	WebDriver driver;
	
	
/*** Page Constructor   ***/
 public LoginPage(WebDriver driver)
 {
       // TODO Auto-generated constructor stub
       this.driver=driver;
	   PageFactory.initElements(driver, this);
 }
/***  WebElements  ***/
		
	@FindBy(id="loginform-username")
	private WebElement userName;
	
	@FindBy(id="loginform-password")
	private WebElement pass;
	
	@FindBy(xpath="//h1[text()='Login']'")
	private WebElement loginlogo;
	
	@FindBy(xpath="//button[@name='login-button']")
	private WebElement log;
	
	@FindBy(xpath="//*[contains(text(),'Incorrect username')]")
	private WebElement invalidLoginmsg;
	
	@FindBy(xpath="//input[@id='loginform-rememberme']")
    private WebElement remembermecheck;
	
	@FindBy(xpath ="//a[text()='reset it']")
	private WebElement resetLink;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement loginLogo;
	
	@FindBy(xpath="//p[text()='Username cannot be blank.']")
	private WebElement userNameBlankErrorMsg;
	
	@FindBy(xpath="//p[text()='Password cannot be blank.']")
	private WebElement passwordBlankErrorMsg;
	
	@FindBy(xpath="//h1[text()='Login']")
	private WebElement loginlogoTxt;
	
	
	/***  User Actions  ***/
	
public String pageTitle()
{
	return PageUtility.getPageTitle(driver);
}
public void enterLoginCredentials(String uName,String passWD) 
{
	PageUtility.enterText(userName, uName);
	PageUtility.enterText(pass,passWD);
}
public void enternumericPassword(int pName)
{
	String s=String.valueOf(pName);  
	PageUtility.enterText(pass, s);
}

public boolean getRemembermeStatus() 
{
	return PageUtility.isElementSelected(remembermecheck);
}


public void ClickOnRemembermeCheckBox()
{
	PageUtility.clickOnelement(remembermecheck);
}

public void getLoginLogo()
{
	PageUtility.getElementText(loginLogo);
	
}
 public HomePage clickOnLoginButton()
 {
    PageUtility.clickOnelement(log);
    return new HomePage(driver);
 }
   public String getInvalidLoginMessage()
	{
		return PageUtility.getElementText(invalidLoginmsg);
	}
   public void getSoftWaitLocateLoginButton()
	{
		WaitUtility.waitForelementTobeClickable(driver,log,LocatorType.Xpath);
	}
   public void getSoftWaitLocateLogoDropdwnButton()
	{
		WaitUtility.waitForelementTobeClickable(driver,loginLogo,LocatorType.Xpath);
	}
	public void getSoftWaitLocateInvalidMsg()
	{
		//WaitUtility.waitForElement(driver, getInvalidLoginMessage(),LocatorType.Xpath);
		WaitUtility.waitForelementVisibility(driver, invalidLoginmsg, LocatorType.Xpath);
	}
	public void getSoftWaitLocateBlankMsg()
	{
		//WaitUtility.waitForElement(driver, getInvalidLoginMessage(),LocatorType.Xpath);
		WaitUtility.waitForelementVisibility(driver, userNameBlankErrorMsg, LocatorType.Xpath);
	}
   public ResetPage clickResetLink()
   {
		PageUtility.clickOnelement(resetLink);
		return new ResetPage(driver);
	}
   public boolean getLoginlogoStatus()
   {
	   return PageUtility.isElementDisplayed(loginLogo);
   }


public String getUserNameBlankErrorMsg() {
	// TODO Auto-generated method stub
	return PageUtility.getElementText(userNameBlankErrorMsg);
}


public String getPasswordBlankErrorMsg() {
	// TODO Auto-generated method stub
	return PageUtility.getElementText(passwordBlankErrorMsg);
}
   
   public String getLoginLogoTxt()
   {
	   return PageUtility.getElementText(loginlogoTxt);
   }
   
 
	
	  
	 
	 

}
