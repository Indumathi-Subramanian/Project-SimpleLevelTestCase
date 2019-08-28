package com.training.sanity.tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.FilterPOM;
import com.training.pom.LoginPOM;
import com.training.sanity.tests.LoginTests;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FilterOrder extends LoginTests{
	
	private FilterPOM FilterPOM;
	//private static ExtentReports extent;
	//private static ExtentTest logger;
		
	@Test(priority=2)
	//Enter OrderId,Name and Filter Order
	public void validateFilterOrder() throws InterruptedException {
		FilterPOM = new FilterPOM(driver); 
		
		   //logger = extent.startTest("validateFilterOrder");
				FilterPOM.clickSales();
				FilterPOM.clickOrder();
				FilterPOM.sendOrderid("243");
				FilterPOM.sendCustName("Indu S");
				FilterPOM.clickFilter();
				WebElement Item = driver.findElement(By.xpath("//*[@id='form-order']/div/table/tbody/tr/td[3]"));
				Assert.assertTrue(Item.isDisplayed());
				logger.log(LogStatus.PASS, "Order Filtered");
				//extent.endTest(logger);
				//extent.flush();
				//extent.close();
				
				screenShot.captureScreenShot("Second");
				Thread.sleep(3000);
		
		}
}
