package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RegistrationPOM;
import com.training.pom.LoginPOM;
import com.training.pom.GrantLoanPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CYTC_55Test {
	private WebDriver driver;
	private String baseUrl;
	private RegistrationPOM registrationPOM;
	private GrantLoanPOM GrantLoanPOM;
	private LoginPOM loginPOM;
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
		registrationPOM = new RegistrationPOM(driver); 
		loginPOM = new LoginPOM(driver);
		GrantLoanPOM=new GrantLoanPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test
	public void validLoginTest() throws InterruptedException {
		registrationPOM.ClickSubmitButton();
		registrationPOM.LoginName("Dhwani9");
		registrationPOM.FullName("Dhwani kumar");
		registrationPOM.Email("Dhwanoq@gmail.com");
		//registrationPOM.Calender("12/02/1992");
		registrationPOM.Gender();
		registrationPOM.Address("2-3-5");
		registrationPOM.PostalCode("2341");
		registrationPOM.City("hyd");
		registrationPOM.Area();
		registrationPOM.Phone("2903995314");
		registrationPOM.MobliePhone("2349858897");
		registrationPOM.Fax("234532");
		registrationPOM.Url("www.google.com");
		registrationPOM.Password("Dhwani");
		registrationPOM.ConfirmPassword("Dhwani");
		
		registrationPOM.Captcha();
		
		registrationPOM.ClickSubmit();
		//screenShot.captureScreenShot("First");
	
	
	
		String result=driver.findElement(By.xpath("//body[@class='main']//tr//tr//tr[1]//td[1]")).getText();
		//String actual=result.trim();
		StringTokenizer st=new StringTokenizer(result);
		String name="";
		while(st.hasMoreTokens())
		{
			name=name+st.nextToken();
		}
		String expected="Thanksforregistering!Youraccounthasbeencreatedandneedstobeactivatedbytheadministration.";
		Assert.assertEquals(name, expected);
	           					
		registrationPOM.clickOK();
		Thread.sleep(3000);
		
		
		loginPOM.sendUserName("admin");
		//Thread.sleep(3000);

	
		loginPOM.sendPassword("password");
		loginPOM.clickLoginBtn();
		//Thread.sleep(3000);
		
		GrantLoanPOM.mem("Pravenya123");
		GrantLoanPOM.sendfullnname("Pravenya Gonuguntla");
		GrantLoanPOM.grantloan();
		Thread.sleep(3000);
		GrantLoanPOM.enteramt("1000000");
		GrantLoanPOM.enterdesc("Loan");
		GrantLoanPOM.submitbtn();
		Thread.sleep(3000);
		GrantLoanPOM.submitbtn2();
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		Thread.sleep(3000);
		String expected1="Profile of Pravenya Gonuguntla";
		String actual1=driver.findElement(By.xpath("//td[contains(text(),'Profile of Pravenya Gonuguntla')]")).getText();
		Assert.assertEquals(expected1,actual1);
		Thread.sleep(3000);
		
	}
}
