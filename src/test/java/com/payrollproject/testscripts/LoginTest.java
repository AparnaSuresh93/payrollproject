package com.payrollproject.testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.payrollproject.utilities.ExcelUtility;
import com.payrollproject.constants.Constants;
import com.payrollproject.pages.HomePage;
import com.payrollproject.pages.LogOutPage;
import com.payrollproject.pages.LoginPage;
import com.payrollproject.pages.ResetPage;

public class LoginTest extends Base{
	LoginPage login;
	ExcelUtility excel;
	HomePage home;
	ResetPage reset = new ResetPage(driver);
	LogOutPage logout;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
	
 @Test(priority=1,description="TC_001 Verify Login Page Logo",enabled= true)
public void verifyLoginPageLogo() 
 {
    login=new LoginPage(driver);
	String actualLogo=login.pageTitle();
	System.out.println(actualLogo);
	String expectedLogo="Login";
	Assert.assertEquals(actualLogo, expectedLogo, "Logo doesnot match");
 }
 
 
 
 @Test(priority=2,description="TC_002 Verify user login with valid user credentials",enabled = true)
 public void verifyUserLoginWithValidUserCredentials() throws IOException, InterruptedException
 {
	 login = new LoginPage(driver);
	 excel = new ExcelUtility(path,"Login");
	 login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
	 //login.enternumericPassword((int)excel.getNumericCellData(1, 1);
	 login.ClickOnRemembermeCheckBox();
     login.getSoftWaitLocateLoginButton();
	 home=login.clickOnLoginButton();
	 login.getSoftWaitLocateLogoDropdwnButton();
	 boolean actualHomeLogoStatus = home.getHomePageLogoStatusDisplayed();
	 SoftAssert softassert = new SoftAssert();
	 softassert.assertTrue(actualHomeLogoStatus, "Login Failed");
	 softassert.assertAll();
	 logout = home.clickOnLogoDropdown();
	 login = logout.clickOnLogoutButton();
	 
	 
 }
 
 
 @Test(priority=3,description="TC_003 Verify user will not login with invalid user credentials",enabled = true)
    public void verifyUserNotLoginWithInvalidUserCredentials() throws IOException, InterruptedException 
 {
	 login = new LoginPage(driver);
	 excel = new ExcelUtility(path,"Login");
	 login.enterLoginCredentials(excel.getStringCellData(4,0),excel.getStringCellData(4, 1));
	 login.clickOnLoginButton();
	 login.getSoftWaitLocateInvalidMsg();
	 String actualTextMsg=login.getInvalidLoginMessage();
	 String expectedTextStatus="Incorrect username or password.";
	 Assert.assertEquals(actualTextMsg,expectedTextStatus,"Login Sucessfull");
}
 
 
 @Test(priority = 4, description = "TC_004 Verify User is able to click on Rememeberme Checkbox",enabled =  true)
	public void verifyUserAbleToClickOnRememeberMeCheckbox() throws IOException
 {
		login = new LoginPage(driver);
		login.ClickOnRemembermeCheckBox();
		boolean checkboxStatus = login.getRemembermeStatus();
		Assert.assertTrue(checkboxStatus,"Unable to check the Rememeberme checkbox");
 }


@Test(priority = 5, description = "TC_005 Verify whether error message is displayed if user click on login button without entering login credentials  ",enabled =  true)
public void verifyErrorMsgOnBlankLoginCredentials() throws IOException
{
	login = new LoginPage(driver);
	login.enterLoginCredentials("","");
	login.ClickOnRemembermeCheckBox();
	login.getSoftWaitLocateBlankMsg();
	String actualUsernameBlankErrorMsg = login.getUserNameBlankErrorMsg();
	String expectedUsernameBlankErrorMsg = "Username cannot be blank.";
	Assert.assertEquals(actualUsernameBlankErrorMsg, expectedUsernameBlankErrorMsg, "Invalid Username Blank Error Message");
	String actualPasswordBlankErrorMsg =  login.getPasswordBlankErrorMsg();
	String expectedPasswordBlankErrorMsg = "Password cannot be blank.";
	Assert.assertEquals(actualPasswordBlankErrorMsg,expectedPasswordBlankErrorMsg,"Invalid Password Blank Error message");
}
}
 
	  


 


