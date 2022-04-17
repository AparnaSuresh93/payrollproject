package com.payrollproject.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.payrollproject.constants.Constants;
import com.payrollproject.pages.HomePage;
import com.payrollproject.pages.LogOutPage;
import com.payrollproject.pages.LoginPage;
import com.payrollproject.pages.ViewWorkerPage;
import com.payrollproject.pages.WorkersPage;
import com.payrollproject.utilities.ExcelUtility;
import com.payrollproject.utilities.WaitUtility;

public class ViewWorkerTest extends Base{
	LoginPage login;
	ExcelUtility excel;
	HomePage home;
	LogOutPage logout; 
	ViewWorkerPage viewworkerpage;
	WorkersPage workers;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
	
	@Test(priority = 30, description = "TC_030_Verify Workers Page View Button", enabled = true)
	public void verifyWorkersPageViewBtn() throws IOException, InterruptedException 
  {
		viewworkerpage = new ViewWorkerPage(driver);
	    workers = new WorkersPage(driver);
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		workers.getSoftWaitWorkersTab();
		home.workersClick();
	  // viewworkerpage.getViewTabElementVisibility();
	   viewworkerpage = workers.ClickonViewButton("Tom Mathew Xaviour");
	   String actualWrkFname = viewworkerpage.getWorkerFirstName();
	   System.out.println(actualWrkFname);
	    String actualWrkEmail = viewworkerpage.getWorkersEmailTxt();
	    System.out.println(actualWrkEmail);
	    excel = new ExcelUtility(path, "ViewWorker");
	    String expectedWrkrFName=excel.getStringCellData(1, 2);
		String expectedWrkEmail=excel.getStringCellData(1, 4);
		SoftAssert softassert=new SoftAssert();
		softassert.assertEquals( actualWrkFname,expectedWrkrFName, "Invalid Worker First name");
		softassert.assertEquals(actualWrkEmail, expectedWrkEmail, "Invalid email");
		softassert.assertAll();
		logout = home.clickOnLogoDropdown();
		login = logout.clickOnLogoutButton();	
		
	}
  
}
