package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegistrationTests {

	private WebDriver driver;
	private String baseUrl;
	private RegistrationPOM registrationPOM;
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
		registrationPOM = new RegistrationPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	
	
	
	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}*/
	
	
	@Test
	public void validLoginTest() {
		registrationPOM.ClickSubmitButton();
		registrationPOM.LoginName("mamu");
		registrationPOM.FullName("mamu");
		registrationPOM.Email("mamu@gmail.com");
		//registrationPOM.Calender("12/02/1992");
		registrationPOM.Gender();
		registrationPOM.Address("2-3-5");
		registrationPOM.PostalCode("2341");
		registrationPOM.City("hyd");
		registrationPOM.Area();
		registrationPOM.Phone("2903843212");
		registrationPOM.MobliePhone("2132467898");
		registrationPOM.Fax("234532");
		registrationPOM.Url("www.google.com");
		registrationPOM.Password("mamu");
		registrationPOM.ConfirmPassword("mamu");
		
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
		
                   						
      }
}
