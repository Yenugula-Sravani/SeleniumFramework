package com.kumaran.SeleniumFramework.pageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.interactions.Actions;

import com.kumaran.SeleniumFramework.AbstractComponents.AbstractComponet;

public class CheckoutPage extends AbstractComponet {

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//handling auto suggestive box
    //a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	//driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy(css=".action__submit")
	WebElement submit;
	
	//driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectingCountry;
	
	
    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	By results=By.cssSelector(".ta-results");
	
	//performing actions by using methods:-Actions a=new Actions(driver);
	public void selectCountry(String countryName) {
		Actions a=new Actions(driver);
		a.sendKeys(selectingCountry, countryName).build().perform();
		waitforelementToAppear(results);
        selectingCountry.click();
	}
	
	public ConfirmationPage submitOrder() {
		submit.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
	
}
