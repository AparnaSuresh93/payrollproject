package com.payrollproject.testscripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.payrollproject.utilities.WaitUtility.LocatorType;


public class ClientsTest extends Base {
	LoginPage login;
	ExcelUtility excel;
	HomePage home;
	CreateClientsPage createclients;
	ClientPage clients;
	LogOutPage logout; 
	String path = System.getProperty("user.dir") + Constants.EXCEL_FILE;
 
  @Test(priority = 14, description = "TC_014_Verify Client Page Search Button using Client Name and Check Reset Button", enabled =  true)
	public void verifyClientPageSearchBtnUsingClientNameandCheckResetBtn() throws IOException, InterruptedException
	{
	    clients = new ClientPage(driver);
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
	    clients.waitforDisplay(); 
		home.clientClick();
	    clients.searchClientName("Amal xaviour");
	    clients.clientSearchBtnClk();
	    clients.waitForClientTable();
	   // clients.clientResetBtnClk();
	    List<ArrayList<String>> data = clients.getTableData();
	    System.out.println("Data are :"+ data);
        excel = new ExcelUtility(path,"Clients");
	    boolean searchStatus = false;
	    for(int i=0;i<data.size();i++)
	    {
	    	if(data.get(i).equals(excel.getStringCellData(1, 1)));
	    	searchStatus = true;
	    	break;
	    } 
	    SoftAssert softassert = new SoftAssert();
	    softassert.assertTrue(searchStatus,"Search Failed");
	    softassert.assertAll();
	    logout = home.clickOnLogoDropdown();
		login = logout.clickOnLogoutButton();	
	}

  @Test(priority = 15, description = "TC_015_Verify Client Page Search Button using Client ID ", enabled =  true)
	public void verifyClientPageSearchBtnUsingClientID() throws IOException, InterruptedException 
     {
		excel = new ExcelUtility(path, "Login");
		clients = new ClientPage(driver);
		login = new LoginPage(driver);
		login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		clients.getSoftWaitClientTab();
		home.clientClick();
	    clients.searchClientID("1");
	    clients.clientSearchBtnClk();
	   // clients.clientResetBtnClk();
	   clients.waitForClientTable();
	   List<ArrayList<String>> data1 = clients.getTableData();
	   System.out.println("Data are:"+data1);
	    excel = new ExcelUtility(path,"Clients");
	    boolean searchStatus = false;
	    for(int i=0;i<data1.size();i++)
	    {
	    	if(data1.get(i).equals(excel.getNumericCellData(1, 0)));
	    	searchStatus = true;
	    	break;
	    }
	    SoftAssert softassert = new SoftAssert();
	    softassert.assertTrue(searchStatus,"Search Failed");
	    softassert.assertAll();
	    logout = home.clickOnLogoDropdown();
	    login = logout.clickOnLogoutButton();
	    }
	   
  @Test(priority = 16, description = "TC_016_Verify Client Page Search using both Client Name and Client Id", enabled =  true)
 	public void verifyClientPageSearchBtn() throws IOException, InterruptedException 
    {
 	    clients = new ClientPage(driver);
 		excel = new ExcelUtility(path, "Login");
 		login = new LoginPage(driver);
 		login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
 		home = login.clickOnLoginButton();
 		clients.getSoftWaitClientTab();
 		home.clientClick();
 		clients.searchClientName("Selenium");
 		clients.searchClientID("5");
	    clients.clientSearchBtnClk();
	    clients.waitForClientTable();
 	    List<ArrayList<String>> data = clients.getTableData();
	    System.out.println("Data are :"+ data);
	    excel = new ExcelUtility(path,"Clients");
	    boolean searchStatus = false;
	    for(int i=0;i<data.size();i++)
	    {
	    	if(data.get(i).equals(excel.getStringCellData(1, 1))&&(data.get(i).equals(excel.getStringCellData(1, 0))));
	    	searchStatus = true;
	    	break;
	    } 
	    System.out.println(searchStatus);
	    SoftAssert softassert = new SoftAssert();
	    softassert.assertTrue(searchStatus,"Search Failed");
	    softassert.assertAll();
 		logout = home.clickOnLogoDropdown();
 		login = logout.clickOnLogoutButton();	
 		
 	}
  
 
  @Test(priority = 19, description = "TC_019_Verify Sorting using Client Id", enabled =  true)
	public void verifySortingUsingClientId() throws IOException, InterruptedException
  {
	    clients = new ClientPage(driver);
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		clients.getSoftWaitClientTab();
		home.clientClick();
	    clients.sortByClientId();
	    excel = new ExcelUtility(path, "Clients");
	    clients.sortClientIdCheck(excel.getNumericCellData(1, 0),excel.getNumericCellData(2, 0),excel.getNumericCellData(3, 0),excel.getNumericCellData(4,0));
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals("0","Not Sorted Client Id");
		logout = home.clickOnLogoDropdown();
		login = logout.clickOnLogoutButton();	
		
	}
  
  @Test(priority = 20, description = "TC_020_Verify Sorting using Client Name", enabled =  true)
 	public void verifySortingUsingClientName() throws IOException, InterruptedException
   {
	   clients = new ClientPage(driver);
 		excel = new ExcelUtility(path, "Login");
 		login = new LoginPage(driver);
 		login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
 		home = login.clickOnLoginButton();
 		clients.getSoftWaitClientTab();
 		home.clientClick();
 	    clients.sortByClientName();
 		logout = home.clickOnLogoDropdown();
 		login = logout.clickOnLogoutButton();	
 		
 	}
  @Test(priority = 21, description = "TC_021_Verify Sorting using Your Ref", enabled =  true)
	public void verifySortingUsingYourRef() throws IOException, InterruptedException
 {
	    clients = new ClientPage(driver);
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		clients.getSoftWaitClientTab();
		home.clientClick();
		//Thread.sleep(1000);
	    clients.sortByYourRef();
		logout = home.clickOnLogoDropdown();
		login = logout.clickOnLogoutButton();	
		
	}
  @Test(priority = 22, description = "TC_022_Verify Sorting using Client Address", enabled =  true)
	public void verifySortingUsingClientAddress() throws IOException, InterruptedException
      {
	    clients = new ClientPage(driver);
		excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		clients.getSoftWaitClientTab();
		home.clientClick();
	    clients.sortByClientAddress();
		logout = home.clickOnLogoDropdown();
		login = logout.clickOnLogoutButton();	
		
	 }
  @Test(priority = 23, description = "TC_023_Verify Sorting using PostCode", enabled =  true)
	public void verifySortingUsingPostCode() throws IOException, InterruptedException
    {
		clients = new ClientPage(driver);
	    excel = new ExcelUtility(path, "Login");
		login = new LoginPage(driver);
		login.enterLoginCredentials(excel.getStringCellData(1, 0),excel.getStringCellData(1, 1));
		home = login.clickOnLoginButton();
		clients.getSoftWaitClientTab();
		home.clientClick();
	    clients.sortByPostCode();
		logout = home.clickOnLogoDropdown();
		login = logout.clickOnLogoutButton();	
		
	 }
  
}
