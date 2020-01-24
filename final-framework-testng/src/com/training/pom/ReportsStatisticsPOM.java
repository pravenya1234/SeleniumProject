package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsStatisticsPOM {
	@SuppressWarnings("unused")
	private WebDriver driver; 
		
		public ReportsStatisticsPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//span[contains(text(),'Reports')]")
		private WebElement reportslink;
		
		@FindBy(xpath="//span[contains(text(),'Statistical analysis')]")
		private WebElement statisticalanalysislink;
		
		@FindBy(xpath="//tr[1]//td[2]//input[1]")	
		private WebElement keydevsubmitbtn;
		
		
		
		public void clickreportslink() {
			this.reportslink.click();
		}



		public void clickstatisticalink() {
			this.statisticalanalysislink.click();
			
		}



		public void clickselectallbtn() {
			this.keydevsubmitbtn.click();
			
		}



		

		
}
