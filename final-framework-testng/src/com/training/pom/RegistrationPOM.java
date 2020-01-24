package com.training.pom;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPOM {

private WebDriver driver; 
	
	public RegistrationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='loginRegistrationDiv']//input[@class='button']")
	private WebElement submitBtn;
	
	
	@FindBy(xpath="//input[@name='member(user).username']")
	private WebElement loginName;
	
	@FindBy(name="member(name)")
	private WebElement fullName;
	
	@FindBy(name="member(email)")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='_id1578902490127_685']")
	private WebElement calender;
	
	@FindBy(id="_radio_2_1")
	private WebElement genderMale;
	
	@FindBy(xpath="//tr[6]//td[2]//input[3]")
	private WebElement address;
	
	@FindBy(xpath="//tr[7]//td[2]//input[3]")
	private WebElement postalCode;
	
	@FindBy(xpath="//tr[8]//td[2]//input[3]")
	private WebElement city;
	
	@FindBy(xpath="//option[contains(text(),'Example area')]")
	private WebElement area;
	
	@FindBy(xpath="//tr[10]//td[2]//input[3]")
	private WebElement phone;
	
	@FindBy(xpath="//tr[11]//td[2]//input[3]")
	private WebElement mobilePhone;
	
	@FindBy(xpath="//tr[12]//td[2]//input[3]")
	private WebElement fax;
	
	@FindBy(xpath="//tr[12]//td[2]//input[3]")
	private WebElement url;
	
	@FindBy(xpath="//input[@name='member(user).password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//input[@id='saveButton']")
	private WebElement clickSubmit;
	
	
	@FindBy(xpath="//input[@name='captcha']")
	private WebElement captcha;
	
	@FindBy(xpath="//input[@id='btn']")
	private WebElement ok;
	
	
	public void ClickSubmitButton()
	{
		this.submitBtn.click();
	}
	
	public void LoginName(String loginname)
	{
		this.loginName.clear();
		this.loginName.sendKeys(loginname);
	}
	
	public void FullName(String fullname)
	{
		this.fullName.clear();
		this.fullName.sendKeys(fullname);
	}
	
	public void Email(String email)
	{
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void Calender(String cal)
	{
		this.calender.clear();
		this.calender.sendKeys(cal);
	}
	
	public void Gender()
	{
		this.genderMale.click();
	}
	
	public void Address(String address)
	{
		this.address.clear();
		this.address.sendKeys(address);
	}
	
	public void PostalCode(String postalcode)
	{
		this.postalCode.clear();
		this.postalCode.sendKeys(postalcode);
	}
	
	public void City(String city)
	{
		this.city.clear();
		this.city.sendKeys(city);
	}
	
	public void Area()
	{
		this.area.click();
	}
	
	public void Phone(String phone)
	{
		this.phone.clear();
		this.phone.sendKeys(phone);
	}
	
	public void MobliePhone(String mobilephone)
	{
		this.mobilePhone.clear();
		this.mobilePhone.sendKeys(mobilephone);
	}
	
	public void Fax(String fax)
	{
		this.fax.clear();
		this.fax.sendKeys(fax);
	}
	
	public void Url(String url)
	{
		this.url.clear();
		this.url.sendKeys(url);
	}
	
	public void Password(String password)
	{
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void ConfirmPassword(String confirmpassword)
	{
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmpassword);
	}
	
	public void Captcha()
	{
		String captchaVal=JOptionPane.showInputDialog("Please enter the captcha value");
		this.captcha.sendKeys(captchaVal);
	}
	public void ClickSubmit()
	{
		this.clickSubmit.click();
	}
	public void clickOK(){
		this.ok.click();
	}
	
	
}
