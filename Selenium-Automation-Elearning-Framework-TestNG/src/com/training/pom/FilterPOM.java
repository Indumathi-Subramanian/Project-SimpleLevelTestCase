package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FilterPOM {
	public WebDriver driver; 
	
	public FilterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@id='menu-sale']/a/i")
   	private WebElement sales;
	
	@FindBy(xpath="//*[@id='menu-sale']/ul/li/a")
   	private WebElement order;
	
	@FindBy(xpath="//*[@id='input-order-id']")
   	private WebElement orderid;
	
	@FindBy(xpath="//*[@id='input-customer']")
   	private WebElement custname;
	
	@FindBy(xpath="//*[@id='button-filter']/i")
   	private WebElement filterbtn;
	
	@FindBy(xpath="//*[@id='form-order']//tbody/tr/td/*[@value='229']")
   	private WebElement chkbox;
	
	@FindBy(xpath="//*[@id='button-delete']/i")
   	private WebElement deletebtn;
	
	@FindBy(xpath="//*[@id='menu-sale']/ul/li[3]/a")
   	private WebElement returnlink;
	
	@FindBy(xpath="//*[@id='input-return-id']")
   	private WebElement returnid;
	
	//@FindBy(xpath="//*[@id='content']/div[2]/div[1]/text()")
	//private WebElement success;
	
	@FindBy(xpath="//*[@id='form-order']/div/table/tbody/tr/td[3]")
	private WebElement item;
	
		
	public void clickSales() {
		this.sales.click(); 
	}
	public void clickOrder() {
		this.order.click(); 
	}
	public void sendOrderid(String orderid) {
		this.orderid.clear(); 
		this.orderid.sendKeys(orderid); 
	}
	public void sendCustName(String custname) {
		this.custname.clear(); 
		this.custname.sendKeys(custname); 
	}
	public void clickFilter() {
		this.filterbtn.click(); 
	}
	public void selectOrder() {
		this.chkbox.click(); 
	}
	public void deleteOrder() {
		this.deletebtn.click(); 
	}
	public void clickReturn() {
		this.returnlink.click(); 
	}
	public void returnId(String returnid) {
		this.returnid.clear(); 
		this.returnid.sendKeys(returnid); 
	}
	public void Alertmsg() {
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	public void SuccessMsg(String success) {
		Assert.assertTrue(success.contains(" Success: You have modified orders!      "));
	}
	/*public void Item() {
		WebElement Item = driver.findElement(By.xpath("//*[@id='form-order']/div/table/tbody/tr/td[3]"));
		this.item.isDisplayed();
	}*/
	
}