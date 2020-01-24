package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GrantLoanPOM {
	@SuppressWarnings("unused")
	private WebDriver driver;

	public GrantLoanPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='memberUsername']")
	private WebElement member;
	@FindBy(xpath="//input[@id='memberName']")
	private WebElement fname;
	
	@FindBy(xpath="//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[4]//input[1]")
	private WebElement grantloan;
	
	@FindBy(xpath="//input[@id='amount']")
	private WebElement amount;
	
	@FindBy(xpath="//textarea[@id='description']")
	private WebElement desc;
	
	@FindBy(xpath="//body[@class='main']/div[@class='layoutMain']/div[@id='topContainer']/div[@class='topContainerBorder']/div[@id='topTable']/div[@id='tdContents']/form[@name='grantLoanForm']/table[@class='defaultTableContent']/tbody/tr/td[@class='tdContentTableForms innerBorder']/table[@class='defaultTable']/tbody/tr/td[1]/input[1]")
	private WebElement submit;
	
	@FindBy(xpath="//table[@class='defaultTable']//input[@class='button']")
	private WebElement submit2;
	
	public void mem(String name){
		this.member.clear();
		this.member.sendKeys(name);
	}

	public void grantloan() {
		this.grantloan.click();
	}

	public void enteramt(String amount) {
		this.amount.sendKeys(amount);
	}

	public void enterdesc(String desc) {
		this.desc.sendKeys(desc);
	}

	public void submitbtn() {
		this.submit.click();		
	}

	public void submitbtn2() {
		this.submit2.click();	
	}

	public void sendfullnname(String fname) {
		// TODO Auto-generated method stub
		this.fname.sendKeys(fname);
		
	}
	
	

}
