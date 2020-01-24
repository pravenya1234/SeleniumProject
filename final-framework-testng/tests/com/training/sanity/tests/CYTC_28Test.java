package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.MessagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_28Test {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private MessagePOM MessagePOM;
	private static Properties properties;
	//@SuppressWarnings("unused")
	//private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		MessagePOM  = new MessagePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	@Test
	public void MessageTest() throws InterruptedException{
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("password");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(3000);
		MessagePOM.clickMesaagelink();
		MessagePOM.clickmessageslink();
		Thread.sleep(2000);
		MessagePOM.clickMessageboxdropdown();
		MessagePOM.clicksubmitbtn();
		Thread.sleep(3000);
		//CYTC_28POM.sendtomember();
		MessagePOM.sendmemloginname("Pravenya");
		Thread.sleep(3000);
		MessagePOM.senmembername("Pravenya Gonuguntla");
		MessagePOM.selectcategory();
		MessagePOM.sendsubjecttextbox("loan repayment");
		MessagePOM.senbodytextbox("Loans");
		Thread.sleep(3000);
		MessagePOM.clicksubmitbtn2();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		String expectedres="Search results";
		String actualres=driver.findElement(By.xpath("//td[contains(text(),'Search results')]")).getText();
		Assert.assertEquals(expectedres, actualres);
		//Thread.sleep(3000);
	}
	
	
	
}
