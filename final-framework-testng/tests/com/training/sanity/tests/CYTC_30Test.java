package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ReportsStatisticsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_30Test {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ReportsStatisticsPOM ReportsStatisticsPOM;
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
		ReportsStatisticsPOM  = new ReportsStatisticsPOM(driver);
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
	public void ManagereportsTest() throws InterruptedException {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("password");
		loginPOM.clickLoginBtn(); 
		Thread.sleep(3000);
		ReportsStatisticsPOM.clickreportslink();
		ReportsStatisticsPOM.clickstatisticalink();
		ReportsStatisticsPOM.clickselectallbtn();
		//ReportsStatisticsPOM.clickprintreportbtn();
		Thread.sleep(3000);
	}
}
