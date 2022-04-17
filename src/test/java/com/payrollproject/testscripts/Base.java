package com.payrollproject.testscripts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Constants;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import com.payrollproject.utilities.WaitUtility;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	
	public WebDriver driver;
	public static Properties properties;
	FileReader f;
	public Base() {

		try {
			f = new FileReader(System.getProperty("user.dir") + "//src//main//resources//Config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		properties = new Properties();
		try {
			properties.load(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void testInitialize(String browserName, String url) throws Exception {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		} else {
			throw new Exception("Invalid Browser Name");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(WaitUtility.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		driver.get(url);

	}


	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void setUp(String browserName) throws Exception {
		String browsername = browserName;
		String url = properties.getProperty("url");
		testInitialize(browsername, url);
	}
	
@AfterMethod
public void tearDown(ITestResult result) throws IOException {		
	if (ITestResult.FAILURE == result.getStatus()) {
			TakesScreenshot takescreenshot = (TakesScreenshot) driver;
			File screenshot = takescreenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./Screenshots/" + result.getName() + ".png"));
		}
		driver.close();
	}


























//@BeforeClass
//public void beforeClass() {
//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
//driver=new ChromeDriver();
//driver.get("https://www.qabible.in/payrollapp");
//driver.manage().window().maximize();
//  }



// @AfterClass
// public void afterClass() {
////driver.close();
// }
//	
	
	
	
//	WebDriver driver;
//	ScreenShot ss;
//	 
//	 @BeforeMethod
//	  public void beforeMethod() {
//
//	String path = System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe";
//	System.setProperty("webdriver.chrome.driver", path);
//	driver = new ChromeDriver();
//	driver.get("https://www.qabible.in/payrollapp");
//	driver.manage().window().maximize();
//	 }

	/* System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://www.qabible.in/payrollapp");
	driver.manage().window().maximize();
	  }*/

	 /* @Parameters("browser")
	  @BeforeMethod
	  public void beforeMethod(String browser)
	  {
	 if(browser.equalsIgnoreCase("chrome"))
	 {
	 System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
	this.driver=new ChromeDriver();
	driver.get("https://www.qabible.in/payrollapp");
	driver.manage().window().maximize();
	  }
	else if (browser.equalsIgnoreCase("edge"))
	 {
	System.setProperty("webdriver.edge.driver", "D:\\Selenium\\msedgedriver.exe");
	this.driver=new EdgeDriver();
	driver.get("https://www.qabible.in/payrollapp");
	driver.manage().window().maximize();
	}
	  }*/
	 
//	  @AfterMethod
//	  public void afterMethod(ITestResult iTestResult) throws IOException {
//	 if (iTestResult.getStatus() == ITestResult.FAILURE) {
//	ss = new ScreenShot();
//	ss.captureScreenShot(driver, iTestResult.getName());
//	}
//	driver.close();
//	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
  
}
