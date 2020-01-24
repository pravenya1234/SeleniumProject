package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MessagePOM {

@SuppressWarnings("unused")
private WebDriver driver; 
	
	public MessagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Messages')]")
	private WebElement Messagelink;
	
	@FindBy(xpath="//span[@class='subMenuText'][contains(text(),'Messages')]")
	private WebElement messageslink;
	
	@FindBy(xpath="//select[@id='messageBoxSelect']")
	private WebElement sentitems;
	
	@FindBy(xpath="//input[@id='newButton']")
	private WebElement submitbtn;
	
	//@FindBy(xpath="//select[@id='sendToSelect']")
	//private WebElement membertype;
	
	@FindBy(xpath="//input[@id='memberUsername']")
	private WebElement memberloginname;
	
	@FindBy(xpath="//input[@id='memberName']")
	private WebElement membername;
	
	@FindBy(xpath="//select[@id='categorySelect']")
	private WebElement category;
	
	@FindBy(xpath="//input[@id='subjectText']")
	private WebElement subjecttextbox;
	
	@FindBy(xpath="//iframe")
	private WebElement bodytextbox;
	
	@FindBy(xpath="//table[@class='defaultTable']//input[@class='button']")
	private WebElement submitbtn2;

	public void clickMesaagelink() {
		this.Messagelink.click();
	}

	public void clickmessageslink() {
		this.messageslink.click();		
	}

	public void clickMessageboxdropdown() {
		Select mestype = new Select(sentitems);
		List<WebElement> list2 = mestype.getOptions();
		list2.get(1).click();		
	}

	public void clicksubmitbtn() {
		this.submitbtn.click();		
	}

	public void sendmemloginname(String memberloginname) {
		this.memberloginname.sendKeys(memberloginname);
	}
	

	public void sendsubjecttextbox(String subjexttextbox) {
		this.subjecttextbox.sendKeys(subjexttextbox);		
	}

	public void senbodytextbox(String bodytextbox) {
		this.bodytextbox.sendKeys(bodytextbox);			
	}

	public void clicksubmitbtn2() {
		this.submitbtn2.click();		
	}

	public void senmembername(String membername) {
		this.membername.sendKeys(membername);
		
	}

	/*public void sendtomember() {
		Select mestype1 = new Select(membername);
		List<WebElement> list2 = mestype1.getOptions();
		list2.get(1).click();
		
	}*/

	public void selectcategory() {
		Select mestype1 = new Select(category);
		List<WebElement> list2 = mestype1.getOptions();
		list2.get(1).click();		
	}
	
	
	
	
	
}
