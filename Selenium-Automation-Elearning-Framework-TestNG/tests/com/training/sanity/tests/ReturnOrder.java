package com.training.sanity.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.FilterPOM;


public class ReturnOrder extends DeleteOrder{
	private FilterPOM FilterPOM;
	
	@Test(priority=4)
	//Enter ReturnId,OrderID and Filter
	public void validateReturnOrder() throws InterruptedException {
		FilterPOM = new FilterPOM(driver);
		
		//logger = extent.startTest("ReturnOrder");
		
		FilterPOM.clickSales();
		FilterPOM.clickReturn();
		FilterPOM.returnId("123");
		FilterPOM.clickFilter();
		FilterPOM.sendOrderid("204");
		FilterPOM.clickFilter();
		WebElement ReturnItem = driver.findElement(By.xpath("//*[@id='form-return']/div/table/tbody/tr/td[4]"));
		Assert.assertTrue(ReturnItem.isDisplayed());
		logger.log(LogStatus.PASS, "Order Returned");
		//extent.endTest(logger);
		//extent.flush();
		//extent.close();
		
		screenShot.captureScreenShot("Fourth");
		Thread.sleep(3000);
	}
	
}
