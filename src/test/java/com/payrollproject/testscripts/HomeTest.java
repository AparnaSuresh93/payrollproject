package com.payrollproject.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.payrollproject.constants.Constants;
import com.payrollproject.pages.HomePage;
import com.payrollproject.pages.LogOutPage;
import com.payrollproject.pages.LoginPage;
import com.payrollproject.utilities.ExcelUtility;
import com.payrollproject.utilities.PageUtility;
import com.payrollproject.utilities.WaitUtility;

public class HomeTest extends Base 
{
	ExcelUtility excel;
	LoginPage login;
	HomePage home;
	LogOutPage logout;
	
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;;
	
	
	
  @Test(priority=12,description="TC_012 Verify user is able to view Home Page Logo Status Dropdown",enabled =  true)
  public void verifyHomePageLogoDropdown() throws IOException, InterruptedException
  {
	  excel = new ExcelUtility(path, "Login");
	  login = new LoginPage(driver);
	  login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
	  home = login.clickOnLoginButton();
	  home.logoDropdwnDisplaywait();
	  boolean display = home.clickOnLogoDropDownDisplay();
	  System.out.println(display);
	  Assert.assertTrue(display,"Logo is not displayed");
	  logout = home.clickOnLogoDropdown();
	  login = logout.clickOnLogoutButton();
  }
  
  @Test(priority = 13, description = "TC_013_Verify Home page Welcome text", enabled =  true)
	public void verifyHomePageTitle() throws IOException, InterruptedException 
	{
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		home.getHomePageWelcomeTxtWait();
		String actualText = home.getHomePageWelcomeText();
		System.out.println(actualText);
		String expectedText = "Welcome to Payroll Application";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualText, expectedText, "Invalid home page Welcome Text");
		softassert.assertAll();
		logout = home.clickOnLogoDropdown();
		login = logout.clickOnLogoutButton();
	}
}
