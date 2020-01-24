package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="//div[@id='virtualKeyboard']//div//input[@class='button']")
	private WebElement loginBtn; 
	/*---starting of manage loan test case---*/
	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Accounts')]")
	private WebElement menu;
	@FindBy(xpath="//span[contains(text(),'Manage Loans')]")
	private WebElement manageLoans;
	@FindBy(id="memberUsername")
	private WebElement MemberName;
	@FindBy(xpath="//input[@class='button']")
	private WebElement submitbutton;
	
	@FindBy(xpath="//img[@class='details view']")
	private WebElement searchlink;
	/*---ending of manage loan test case---*/
	
	
	public void sendUserName(String userName) {
		
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		 
		driver.findElement(By.xpath("//body[@class='login']/div[@id='topContainer']/div[@class='topContainerBorder']/div[@id='topTable']/div[@id='tdContents']/table[@class='loginTable']/tbody/tr/td[@class='loginFormContainer']/table[@class='nested loginFormTable']/tbody/tr/td[@class='loginForm']/form[@id='cyclosLogin']/table[@class='nested']/tbody/tr/td/div[@id='virtualKeyboard']/div/input[1]")).click();
		driver.findElement(By.xpath("//body[@class='login']/div[@id='topContainer']/div[@class='topContainerBorder']/div[@id='topTable']/div[@id='tdContents']/table[@class='loginTable']/tbody/tr/td[@class='loginFormContainer']/table[@class='nested loginFormTable']/tbody/tr/td[@class='loginForm']/form[@id='cyclosLogin']/table[@class='nested']/tbody/tr/td/div[@id='virtualKeyboard']/div/input[2]")).click();
		driver.findElement(By.xpath("//body[@class='login']/div[@id='topContainer']/div[@class='topContainerBorder']/div[@id='topTable']/div[@id='tdContents']/table[@class='loginTable']/tbody/tr/td[@class='loginFormContainer']/table[@class='nested loginFormTable']/tbody/tr/td[@class='loginForm']/form[@id='cyclosLogin']/table[@class='nested']/tbody/tr/td/div[@id='virtualKeyboard']/div/input[3]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/form[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/div[1]/input[4]")).click();
		
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}	
	public void clickAccountslink(){
		this.menu.click();
	
	}
	/*---starting of manage loan test case---*/
	public void sendMemberName(String MemberName){
		this.MemberName.sendKeys(MemberName);
	}

	public void clickManageLoan() {
		// TODO Auto-generated method stub
		this.manageLoans.click();
	}
	public void clicksubmitbutton(){
		this.submitbutton.click();
	}
	
	public void clicksearch() {
		this.searchlink.click();
	/*------completion of manage loan test case---*/	
	}
	
}
