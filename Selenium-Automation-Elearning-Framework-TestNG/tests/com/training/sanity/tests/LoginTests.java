package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.FilterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	public static WebDriver driver;
	private static String baseUrl;
	private static LoginPOM loginPOM;
	private static FilterPOM FilterPOM;
	private static Properties properties;
	public static ScreenShot screenShot;
	public static ExtentReports extent;
	protected static ExtentTest logger;

	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		FilterPOM = new FilterPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		
		//ExtentReports
		//logger = extent.startTest("LoginTests");
		ExtentReports extent;
		ExtentTest logger;
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/indu1.html",true);
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		logger = extent.startTest("LoginTests");
		
		//Screenshot
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		extent.endTest(logger);
		extent.flush();
		extent.close();
		Thread.sleep(3000);
		driver.quit();
	}
		
	@Test (priority=1)
	//Login to Retail Website
	public void validLoginTest() throws InterruptedException {
		//logger = extent.startTest("LoginTests");
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		String Exptitle=driver.getTitle();
		String ActTitle="Dashboard";
		Assert.assertEquals(Exptitle,ActTitle);
		logger.log(LogStatus.PASS, "Logged in");
		//extent.endTest(logger);
		//extent.flush();
		//extent.close();
		
		//Take Screenshot
		screenShot.captureScreenShot("First");
			
	}
	
}
