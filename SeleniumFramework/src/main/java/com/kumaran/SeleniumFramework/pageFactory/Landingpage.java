package com.kumaran.SeleniumFramework.pageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.kumaran.SeleniumFramework.AbstractComponents.AbstractComponet;

public class Landingpage extends AbstractComponet {

	WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

		
	//WebElement useremail=driver.findElement(By.id("userEmail"));
	
	//pagefactory intilization
	@FindBy(id="userEmail")
	 WebElement useremail;
	
    //driver.findElement(By.id("userPassword"))
	@FindBy(id="userPassword")
	 WebElement userPassword;
	
	//driver.findElement(By.id("login"))
	@FindBy(id="login")
	 WebElement submit;
	
	public productCateloge LoginApplication(String email,String pass) {
		useremail.sendKeys(email);
		userPassword.sendKeys(pass);
		submit.click();
		productCateloge pc=new productCateloge(driver);
		return pc;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	

}
