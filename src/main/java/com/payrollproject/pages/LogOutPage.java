package com.payrollproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payrollproject.utilities.PageUtility;

public class LogOutPage {
	WebDriver driver;
	
	/***   Page Constructor   ***/
	public LogOutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/***   WebElements   ***/
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logout;
	
	/*** UserActionMethods   ***/
	public LoginPage clickOnLogoutButton()
	{
		PageUtility.clickOnelement(logout);
		return new LoginPage(driver);
	}
	
	

}
