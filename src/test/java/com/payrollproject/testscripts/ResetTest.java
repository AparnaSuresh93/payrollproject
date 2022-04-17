package com.payrollproject.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.payrollproject.constants.Constants;
import com.payrollproject.pages.LoginPage;
import com.payrollproject.pages.ResetPage;
import com.payrollproject.utilities.ExcelUtility;
import com.payrollproject.utilities.PageUtility;
import com.payrollproject.utilities.WaitUtility;

public class ResetTest extends Base{

	LoginPage login;
	ExcelUtility excel;
	ResetPage reset;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
 

	
  @Test(priority=6,description="TC_006_Verify error message displayed on Reset Password page with invalid email id",enabled =  true)
  public void verifyResetLinkInvalidEmailId() throws IOException, InterruptedException
  {
 	 excel = new ExcelUtility(path,"Login");
 	 login = new LoginPage(driver);
 	 reset = login.clickResetLink();
 	 reset.enterEmailTextbox(excel.getStringCellData(1, 2));
 	 reset.clickOnSendBtn();
 //  reset.clickOnCancelBtn();
 	 reset.getErrorMsgDisplayWait();
 	 String actualErrorMessage = reset.getInvalidEmailErrorMsg();
 	 String expectedErrorMessage="There is no user with this email address.";
 	 boolean errorMsgStatus=actualErrorMessage.equals(expectedErrorMessage);
 	 SoftAssert softassert = new SoftAssert();
 	 softassert.assertTrue(errorMsgStatus,"Invalid Email Error message doesnot matched");
 	
  }
  
  @Test(priority=7,description="TC_007_Verify the error message displayed on Reset Password page with Blank email id",enabled =  true)
  public void verifyResetLinkBlankEmail() throws IOException, InterruptedException
  {
 	// excel = new ExcelUtility(path,"Login");
 	 login = new LoginPage(driver);
 	 reset = login.clickResetLink();
 	 reset.enterEmailTextbox("");
 	 reset.clickOnSendBtn();
 	 //reset.clickOnCancelBtn();
 	 reset.getBlankErrorMsgWait();
 	 String actualEmailBlankErrorMsg = reset.getEmailBlankErrorMsg();
  	 String expectedEmailBlankErrorMsg = "Email cannot be blank.";
 	 boolean errorMsgStatus = actualEmailBlankErrorMsg.equals(expectedEmailBlankErrorMsg);
 	 SoftAssert softassert = new SoftAssert();
 	 softassert.assertTrue(errorMsgStatus,"Email Blank Error message doesnot matched");
 	
  }
  
  @Test(priority=8,description="TC_008 Verify Reset Page Title",enabled=  true)
  public void verifyResetPageTitle() 
   {
	login = new LoginPage(driver);
	reset = login.clickResetLink();
  	String actualTitle = reset.pageTitle();
  	System.out.println(actualTitle);
  	String expectedTitle="Password reset";
  	Assert.assertEquals(actualTitle, expectedTitle, "Title doesnot match");
   }
  
  @Test(priority=9,description="TC_009_Verify the error message is displayed on Reset Password page with incorrect format email text",enabled =  true)
  public void verifyResetLinkIncorrectEmailFormat() throws IOException, InterruptedException
  {
 	 excel = new ExcelUtility(path,"Login");
 	 login = new LoginPage(driver);
 	 reset = login.clickResetLink();
 	 reset.enterEmailTextbox(excel.getStringCellData(3,2));
 	 reset.clickOnSendBtn();
 	 //reset.clickOnCancelBtn();
 	 reset.getIncorrectFormatEmailMsgWait();
 	 String actualIncorrectEmailErrorMsg = reset.getInvalidFormatEmailMsg();
 	 System.out.println(actualIncorrectEmailErrorMsg);
     String expectedIncorrectEmailErrorMsg = "Email is not a valid email address.";
   	 boolean errorMsgStatus = actualIncorrectEmailErrorMsg.equals(expectedIncorrectEmailErrorMsg);
 	 Assert.assertTrue(errorMsgStatus,"Incorrect Email Error message doesnot matched");
 	
  }
  
  @Test(priority=10,description="TC_010_Verify the user is able to click cancel button of the reset page and navigate back to Login page",enabled =  true)
  public void verifyResetPageCancelBtn() throws IOException
  {
 	 login = new LoginPage(driver);
 	 reset = login.clickResetLink();
 	 //reset.clickOnSendBtn(); 
 	 login = reset.clickOnCancelBtn();
 	 String loginTxt=login.getLoginLogoTxt();
 	 boolean flag=loginTxt.equals("Login");
 	 Assert.assertTrue(flag,"Cancel button not working Properly");
  }
  

}


