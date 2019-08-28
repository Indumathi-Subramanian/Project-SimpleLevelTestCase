package com.training.sanity.tests;
import static org.testng.Assert.assertTrue;

import java.util.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.FilterPOM;


public class DeleteOrder extends FilterOrder{
	private FilterPOM FilterPOM;
		
	@Test(priority=3)
	//Enter OrderID, Select and Delete order
	public void validateDeleteOrder() throws InterruptedException {
		FilterPOM = new FilterPOM(driver);
		
		//logger = extent.startTest("DeleteOrder");
		FilterPOM.clickSales();
		FilterPOM.clickOrder();
		FilterPOM.sendOrderid("229");
		FilterPOM.clickFilter();
		FilterPOM.selectOrder();
		FilterPOM.deleteOrder();
		FilterPOM.Alertmsg();
		Thread.sleep(1000);
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//String sText =  js.executeScript("return document.documentElement.innerText;").toString();
		
		WebElement tick = driver.findElement(By.xpath("//*[@class='fa fa-check-circle']"));
		Assert.assertTrue(tick.isDisplayed());
		logger.log(LogStatus.PASS, "Order Deleted");
		//extent.endTest(logger);
		//extent.flush();
		//extent.close();
		
		//String Actual = msg.getText();
		//System.out.println(Actual);
		//String Expected =" Success: You have modified orders!      ";
		//Assert.assertEquals(Actual, Expected);
		
		screenShot.captureScreenShot("Third");
		
	}
	

}
