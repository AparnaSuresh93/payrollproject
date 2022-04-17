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
import com.payrollproject.pages.WorkersPage;
import com.payrollproject.utilities.ExcelUtility;
import com.payrollproject.utilities.WaitUtility;

public class WorkersTest extends Base {
	LoginPage login;
	ExcelUtility excel;
	HomePage home;
	LogOutPage logout; 
	WorkersPage workers;
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
	
@Test(priority = 26, description = "TC_026_Verify Workers Page Search Button using FirstName ", enabled =  true)
public void verifyWorkersPageSearchBtnUsingFirstName() throws IOException, InterruptedException 
    {
			excel = new ExcelUtility(path, "Login");
			workers = new WorkersPage(driver);
			login = new LoginPage(driver);
			login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
			home = login.clickOnLoginButton();
			workers.getSoftWaitWorkersTab();
			home.workersClick();
			workers.searchByWorkerfirstName("Tom");
            workers.workersSearchBtnClk();
            workers.getSoftWaitWorkersTab();
           List<ArrayList<String>> data = workers.getTableData();
           System.out.println("Data are::"+data);
           excel = new ExcelUtility(path,"Workers");
           boolean searchStatus = false;
           for (int i = 0; i < data.size(); i++) {
   			if (data.get(i).equals(excel.getStringCellData(1, 1)));
   			searchStatus = true;
   			break;
   		}
   		SoftAssert softassert = new SoftAssert();  
   		softassert.assertTrue(searchStatus, "search Failed");
   		softassert.assertAll();
     	logout = home.clickOnLogoDropdown();
    	login = logout.clickOnLogoutButton();	
			
   }
@Test(priority = 27, description = "TC_027_Verify Workers Page Search Button using LastName ", enabled =  true)
public void verifyWorkersPageSearchBtnUsingLastName() throws IOException, InterruptedException 
    {
			excel = new ExcelUtility(path, "Login");
			workers = new WorkersPage(driver);
			login = new LoginPage(driver);
			login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
			home = login.clickOnLoginButton();
			workers.getSoftWaitWorkersTab();
			home.workersClick();
			workers.searchByWorkerlastName("Benny");
            workers.workersSearchBtnClk();
            workers.getSoftWaitWorkersTab();
            List<ArrayList<String>> data = workers.getTableData();
             System.out.println("Data are::"+data);
             excel = new ExcelUtility(path,"Workers");
             boolean searchStatus = false;
             for (int i = 0; i < data.size(); i++) {
     			if (data.get(i).equals(excel.getStringCellData(2, 7)));
     			searchStatus = true;
     			break;
     		}
     		SoftAssert softassert = new SoftAssert();  
     		softassert.assertTrue(searchStatus, "search Failed");
     		softassert.assertAll();
     		logout = home.clickOnLogoDropdown();
    		login = logout.clickOnLogoutButton();	
			
   }
@Test(priority = 28, description = "TC_028_Verify Workers Page Search Button using PostCode ", enabled =  true)
public void verifyWorkersPageSearchBtnUsingPostCode() throws IOException, InterruptedException 
    {
			excel = new ExcelUtility(path, "Login");
			workers = new WorkersPage(driver);
			login = new LoginPage(driver);
			login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
			home = login.clickOnLoginButton();
			workers.getSoftWaitWorkersTab();
			home.workersClick();
			workers.searchByWorkerPostCode("dddd");
            workers.workersSearchBtnClk();
            workers.getSoftWaitWorkersTab();
            List<ArrayList<String>> data = workers.getTableData();
             System.out.println("Data are::"+data);
             excel = new ExcelUtility(path,"Workers");
             boolean searchStatus = false;
             for (int i = 0; i < data.size(); i++) {
     			if (data.get(i).equals(excel.getStringCellData(1, 4)));
     			searchStatus = true;
     			break;
     		}
     		SoftAssert softassert = new SoftAssert();  
     		softassert.assertTrue(searchStatus, "search Failed");
     		softassert.assertAll();
     		logout = home.clickOnLogoDropdown();
    		login = logout.clickOnLogoutButton();	
			
   }
@Test(priority = 29, description = "TC_029_Verify Workers Page Search Button using Ni Number ", enabled =  true)
public void verifyWorkersPageSearchBtnUsingNiNumber() throws IOException, InterruptedException 
    {
			excel = new ExcelUtility(path, "Login");
			workers = new WorkersPage(driver);
			login = new LoginPage(driver);
			login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
			home = login.clickOnLoginButton();
			workers.getSoftWaitWorkersTab();
			home.workersClick();
			workers.searchByWorkerNiNumber("12");
            workers.workersSearchBtnClk();
            workers.getSoftWaitWorkersTab();
            List<ArrayList<String>> data = workers.getTableData();
            WaitUtility.hardWait();
             System.out.println("Data are::"+data);
             excel = new ExcelUtility(path,"Workers");
             boolean searchStatus = false;
             for (int i = 0; i < data.size(); i++) {
     			if (data.get(i).equals(excel.getStringCellData(2, 7)));
     			searchStatus = true;
     			break;
     		}
     		SoftAssert softassert = new SoftAssert();  
     		softassert.assertTrue(searchStatus, "search Failed");
     		softassert.assertAll();
     		logout = home.clickOnLogoDropdown();
    		login = logout.clickOnLogoutButton();	
			
   }

}
