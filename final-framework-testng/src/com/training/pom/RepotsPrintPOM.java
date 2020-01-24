package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepotsPrintPOM {
	@SuppressWarnings("unused")
	private WebDriver driver; 
		
		public RepotsPrintPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//span[contains(text(),'Reports')]")
		private WebElement reportslink;
		
		@FindBy(xpath="//span[contains(text(),'Member lists')]")
		private WebElement memberlistslink;
		
		@FindBy(xpath="//input[@id='selectAllButton']")
		private WebElement selectallbtn;
		
		@FindBy(xpath="//input[@id='selectAllButton']")
		private WebElement printreportbtn;

		public void clickreportslink() {
			this.reportslink.click();
		}

		public void clickmemberlistlink() {
			this.memberlistslink.click();
		}

		public void clickselectallbtn() {
			this.selectallbtn.click();	
		}

		public void clickprintreportbtn() {
			this.selectallbtn.click();
		}
}
