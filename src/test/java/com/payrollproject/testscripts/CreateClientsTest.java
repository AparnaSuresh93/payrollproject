package com.payrollproject.testscripts;
import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.payrollproject.constants.Constants;
import com.payrollproject.pages.ClientPage;
import com.payrollproject.pages.CreateClientsPage;
import com.payrollproject.pages.HomePage;
import com.payrollproject.pages.LogOutPage;
import com.payrollproject.pages.LoginPage;
import com.payrollproject.utilities.ExcelUtility;
import com.payrollproject.utilities.PageUtility;
import com.payrollproject.utilities.WaitUtility;

public class CreateClientsTest extends Base{
	LoginPage login;
	ExcelUtility excel;
	HomePage home;
	CreateClientsPage createclients;
	ClientPage clients;
	LogOutPage logout; 
	
	String path= System.getProperty("user.dir") + Constants.EXCEL_FILE;;
	
@Test(priority = 24, description = "TC_024_Verify the error message displayed without filling mandatory fields in Create Client form", enabled =  true)
 public void verifyErrorMessageDisplayedWithoutFillingMandatoryFields () throws IOException, InterruptedException {
	  createclients = new CreateClientsPage(driver);
	  clients =new ClientPage(driver);
	  excel = new ExcelUtility(path, "Login");
	  login = new LoginPage(driver);
	  login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
	  home = login.clickOnLoginButton();
	  clients.getSoftWaitClientTab();
      home.clientClick();
      clients.createClientClk();
	  createclients.scrollPage();
	  createclients.clksaveBtn();
	  WaitUtility.implicitWaitMeth(driver);
	  String expectedErrorMsg="Branch cannot be blank.";
	  String actualErrorMsg=createclients.getErrorMsg();
	  System.out.println(actualErrorMsg);
	  SoftAssert softassert = new SoftAssert();
	  softassert.assertEquals(actualErrorMsg, expectedErrorMsg, "Failed Error Message");
	  softassert.assertAll();
	  logout = home.clickOnLogoDropdown();
	  login = logout.clickOnLogoutButton();	
		
}
	  
@Test(priority = 25, description = "TC_025_Verify New Client Creation", enabled =  true)
   public void verifyNewClientCreation () throws IOException, InterruptedException {
	      createclients = new CreateClientsPage(driver);
	 	  clients =new ClientPage(driver);
	 	  excel = new ExcelUtility(path, "Login");
	 	  login = new LoginPage(driver);
	 	  login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
	 	  home = login.clickOnLoginButton();
	 	 clients.getSoftWaitClientTab();
	      home.clientClick();
	      clients.createClientClk();
	 	  createclients.selectBranchDropDown();
	 	 // List<String> actualbranch = createclients.selectBranchDropdwn("New_Alpha");
	 	 // System.out.println(actualbranch);
     	  createclients.enterYouRef("Reema");
	 	  createclients.selectInvoiceOrderDropDown();
	 	  createclients.selectDivisionDropdwn();
	 	  createclients.enterInvoiceContactTxt(908765400);
	 	  createclients.selectInvoiceDelvMethDropdwn();
	 	  createclients.enterClientNameTxt("Parvathy");
	 	  createclients.enterPhoneTxt(1234567890);
	 	  createclients.selectMasterDocumentDropdwn();
	 	  createclients.enterClientAddress("Trivandrum");
	 	  createclients.enterFaxTxt(456);
	 	  createclients.enterSettlementDaysTxt(20);
	 	  createclients.enterPostCodeTxt(686105);
	 	  createclients.enterEmailTxt("Parvathy@gmail.com");
	 	  createclients.selectVATRate();
	 	  createclients.enterCmpnyRegTxt("TATA");
	 	  createclients.enterCountryTxt("India");
	 	  createclients.scrollPage();
	 	  createclients.clksaveBtn();
	 	  boolean flag=createclients.isDisplayedProfileName();
	 	  System.out.println(flag);
	 	  Assert.assertTrue(flag,"New Client Creation Failed");
	 	  logout = home.clickOnLogoDropdown();
		  login = logout.clickOnLogoutButton();	
	  }
	
	

}
