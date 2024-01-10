package com.kumaran.SeleniumFramework.pageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.kumaran.SeleniumFramework.AbstractComponents.AbstractComponet;

public class ConfirmationPage extends AbstractComponet {

	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
     //String confirmedtxt = driver.findElement(By.cssSelector(".hero-primary")).getText();
      @FindBy(css=".hero-primary")
      WebElement confirmedtxt;
      
      public String getConfirmationMsg() {
    	  return confirmedtxt.getText();
      }
	  
     public closeDriver closedriver() { 
    	 closeDriver cd=new closeDriver(driver);
    	 return cd;
     }
}
