package com.kumaran.SeleniumFramework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import com.kumaran.SeleniumFramework.pageFactory.*;

public class AbstractComponet {
	
	WebDriver driver;
	public AbstractComponet(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//clicking on the cart
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartheader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderheader;

	public void waitforelementToAppear(By findby) {
		//after clicking login,we should wait for 5seconds,so applying the explicit wait here
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitforElementDisappear(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		//ng-animating
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage gotocart() {
		cartheader.click();
		 CartPage cp=new CartPage(driver);
		 return cp;
	}
	
	public orderPage gotoorderpage() {
		orderheader.click();
		orderPage op=new orderPage(driver);
		 return op;
	}

}
