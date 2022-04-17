package com.payrollproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payrollproject.utilities.PageUtility;
import com.payrollproject.utilities.WaitUtility;
import com.payrollproject.utilities.WaitUtility.LocatorType;


public class HomePage {
	WebDriver driver;
	
	/***  Page Constructor   ***/
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*** WebElements ***/
	@FindBy(xpath="//li[@class='profile-dropdown']")
	private WebElement homeLogoTitle;
	
	@FindBy(xpath="//p[text()='Welcome to Payroll Application']")
	private WebElement homePageWelcomeTxt;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement logoDropdown;
	

	@FindBy(xpath="//a[text()='Clients']")
	private WebElement clientsTab;
	
	 @FindBy(linkText="Workers")
	 private WebElement workersTab;
	
	/*** User Action Methods ***/

	public boolean getHomePageLogoStatusDisplayed() 
	{
		return PageUtility.isElementDisplayed(homeLogoTitle);
	}
	
	public LogOutPage clickOnLogoDropdown()
	{
		PageUtility.clickOnelement(logoDropdown);
		return new LogOutPage(driver);
		
	}
	public String getHomePageWelcomeText()
	{
		return PageUtility.getElementText(homePageWelcomeTxt);
	}
	public void getHomePageWelcomeTxtWait()
	{
		WaitUtility.waitForelementVisibility(driver,homePageWelcomeTxt,LocatorType.Xpath);
	}
	
	public boolean clickOnLogoDropDownDisplay()
	{
		return PageUtility.isElementDisplayed(logoDropdown);
	}

	public String getHomePageTitle() {
		// TODO Auto-generated method stub
		return PageUtility.getPageTitle(driver);
	}
	public void logoDropdwnDisplaywait()
	{
		WaitUtility.waitForelementVisibility(driver,homeLogoTitle ,LocatorType.Xpath);
	}
	
	public void clientClick()
	{
		PageUtility.clickOnelement(clientsTab);
	}
	 public void workersClick()
		{
			PageUtility.clickOnelement(workersTab);
		}

}
