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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_26Test {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
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
		loginPOM.clickAccountslink();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//li[@id='menu3']")).click();
		//Thread.sleep(3000);
		loginPOM.clickManageLoan();
		loginPOM.sendMemberName("Pravenya");
		loginPOM.clicksubmitbutton();
		loginPOM.clicksearch();
		String expectedresult="Show the related payment";
		String actualresult=driver.findElement(By.xpath("//a[@id='openTransferLink']")).getText();
		Assert.assertEquals(expectedresult,actualresult );
		screenShot.captureScreenShot("First");
	}
}
