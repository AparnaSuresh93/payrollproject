package com.payrollproject.testscripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.payrollproject.constants.Constants;
import com.payrollproject.pages.ClientPage;
import com.payrollproject.pages.HomePage;
import com.payrollproject.pages.LogOutPage;
import com.payrollproject.pages.LoginPage;
import com.payrollproject.pages.ViewClientPage;
import com.payrollproject.utilities.ExcelUtility;

public class ViewClientTest extends Base {
	LoginPage login;
	HomePage home;
	ExcelUtility excel;
	ClientPage clients;
	LogOutPage logout;
	ViewClientPage viewclient;
	
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
	
	
	@Test(priority = 17, description = "TC_017_Verify the details displayed in the Client Page View Button", enabled = false)
	public void verifyClientPageViewBtn() throws IOException, InterruptedException 
   {
		viewclient = new ViewClientPage(driver);
		clients =new ClientPage(driver);
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		clients.getSoftWaitClientTab();
		home.clientClick();
	    clients.clientViewBtnClkWait();
	    viewclient = clients.ClickonViewButton("Amal xaviour");
	    viewclient.getViewTabElementVisibility();
	    String actualClientName = viewclient.getClientName();
	    String actualClientAddress = viewclient.getClientAddress();
	    String actualEmail = viewclient.getEmail();
	    String expectedClientName = "Amal xaviour";
	    String expectedclientAddress= "Alappuzha";
	    String expectedEmail = 	"hiiiii@gmail.com";
	    SoftAssert softassert = new SoftAssert();
	    softassert.assertEquals(actualClientName, expectedClientName, "Client Name Doesnot Match");
	    softassert.assertEquals(actualClientAddress, expectedclientAddress, "Client Address Doesnot Match");
	    softassert.assertEquals(actualEmail, expectedEmail, "Email Doesnot Match");
	    softassert.assertAll();
		logout = home.clickOnLogoDropdown();
		login = logout.clickOnLogoutButton();	
		
	}
  
}
