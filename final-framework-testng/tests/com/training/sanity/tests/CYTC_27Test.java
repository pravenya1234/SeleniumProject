package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ManagepaymentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_27Test {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ManagepaymentPOM ManagepaymentPOM;
	private static Properties properties;
	@SuppressWarnings("unused")
	private ScreenShot screenShot;

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
		ManagepaymentPOM  = new ManagepaymentPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	@Test
	public void validManageLoanTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("password");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(3000);
		ManagepaymentPOM.clickAccountslink();
		ManagepaymentPOM.clickmemberpaymentlink();
		ManagepaymentPOM.sendloginrecipient("P");
		Thread.sleep(3000);
		//ManagepaymentPOM.sendName("Pravenya Gonuguntla");
		Thread.sleep(4000);
		//ManagepaymentPOM.clickmemberpaymentlink();
		Thread.sleep(4000);
		ManagepaymentPOM.amount("1000000");
		ManagepaymentPOM.description("sold");
		ManagepaymentPOM.submitbtn();
		ManagepaymentPOM.confirmsubmit();
		String expected ="Cyclos";
		String actual=driver.findElement(By.xpath("//td[@class='tdHeaderTable']")).getText();		
		Assert.assertEquals(expected, actual);
		Thread.sleep(3000);
		
	}
	
}

