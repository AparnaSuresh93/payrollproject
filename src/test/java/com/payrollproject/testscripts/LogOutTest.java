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

public class LogOutTest extends Base{
	HomePage home;
	ExcelUtility excel;
	LoginPage login;
	LogOutPage logout;
	
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
	
  @Test(priority=11, description= "TC_011 Verify whether user is navigating to login page by clicking on logout button", enabled =  true)
  public void verifyUserNavigatingToLoginPageByClickingOnLogout() throws IOException {
	  excel = new ExcelUtility(path, "Login");
	  login = new LoginPage(driver);
	  login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
	  home = login.clickOnLoginButton();
	  login.getSoftWaitLocateLogoDropdwnButton();
	  logout = home.clickOnLogoDropdown();
	  boolean actualLoginLogoStatus = login.getLoginlogoStatus();
	  Assert.assertTrue(actualLoginLogoStatus, "Unable to navigate to login Page");
	  login = logout.clickOnLogoutButton();
	  
  }
}
