package com.training.pom;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings("unused")
public class ManagepaymentPOM {
private WebDriver driver; 
	
	public ManagepaymentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Accounts')]")
	private WebElement menu;
	
	@FindBy(xpath="//span[contains(text(),'Member Payment')]")
	private WebElement memberpayment;
	
	@FindBy(xpath="//input[@id='memberUsername']")
	private WebElement loginrecipient;
	
	@FindBy(id="memberName")
	private WebElement name;
	
	@FindBy(xpath=("//input[@id='amount']"))
	private WebElement amount;	
	
	@FindBy(xpath="//select[@id='type']")
	private WebElement type;
	
	@FindBy(xpath="//textarea[@id='description']")
	private WebElement description;	
	
	@FindBy(id=("submitButton"))
	private WebElement submitbtn;

	@FindBy(xpath=("//table[@class='defaultTable']//input[@class='button']"))
	private WebElement csubmit;
	
	public  void clickAccountslink(){
		this.menu.click();
	}
	public  void clickmemberpaymentlink(){
		this.memberpayment.click();
	}
	public void sendloginrecipient(String loginrecipient){
		this.loginrecipient.sendKeys(loginrecipient);
	}
	public void sendName(String name) {
		this.name.sendKeys(name);
		
	}
	public void amount(String amount){
		this.amount.sendKeys(amount);
	}
	public void transactype(){
		Select memtype = new Select(type);
		List<WebElement> list2 = memtype.getOptions();
		list2.get(1).click();
	}
	public void description(String description) {
		this.description.sendKeys(description);
		
	}
	public void submitbtn() {
		this.submitbtn.click();
		
	}
	public void confirmsubmit() {
		this.csubmit.click();		
	}
	

}