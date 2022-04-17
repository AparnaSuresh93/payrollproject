package com.payrollproject.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.payrollproject.constants.Constants;
import com.payrollproject.pages.ClientPage;
import com.payrollproject.pages.CreateClientsPage;
import com.payrollproject.pages.HomePage;
import com.payrollproject.pages.LogOutPage;
import com.payrollproject.pages.LoginPage;
import com.payrollproject.pages.UpdateClientPage;
import com.payrollproject.pages.ViewClientPage;
import com.payrollproject.utilities.ExcelUtility;
import com.payrollproject.utilities.PageUtility;
import com.payrollproject.utilities.WaitUtility;

public class UpdateClientTest extends Base {
	LoginPage login;
	ExcelUtility excel;
	HomePage home;
	CreateClientsPage createclients;
	ClientPage clients;
	LogOutPage logout; 
	UpdateClientPage updateclientpage;
	ViewClientPage viewclient;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
 
 @Test(priority = 18, description = "TC_018_Verify Client Page Update Button", enabled = false)
 public void verifyClientPageUpdateBtn() throws IOException, InterruptedException
  {
     updateclientpage = new UpdateClientPage(driver);
     viewclient = new ViewClientPage(driver);
     clients = new ClientPage(driver);
	 excel = new ExcelUtility(path, "Login");
	 login = new LoginPage(driver);
	 login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
	 home = login.clickOnLoginButton();
	 clients.getSoftWaitClientTab();
	 home.clientClick();
	 clients.clientUpdateBtnClk();
	 clients.enterYourRefTxt("Deepak");
	 updateclientpage.enterUpdateClientemail("hiiiii@gmail.com");	 
	 PageUtility.Scroll(driver);
	 updateclientpage.clickonSaveBtn();
	 //viewclient = clients.ClickonViewButton("Amal xaviour");
     viewclient.getViewTabElementVisibility();
	 String actualClientEmail = viewclient.getEmail();
	 String expectedClientEmail = 	"ing.purchasing@canfordhealthcare.co.uk";
	 SoftAssert softassert = new SoftAssert();
	 softassert.assertEquals(actualClientEmail, expectedClientEmail, "Email Doesnot Match");
	 logout = home.clickOnLogoDropdown();
	 login = logout.clickOnLogoutButton();	
	 		
	 	}
  }
