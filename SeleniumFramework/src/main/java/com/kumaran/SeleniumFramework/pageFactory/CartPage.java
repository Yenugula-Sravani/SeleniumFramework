package com.kumaran.SeleniumFramework.pageFactory;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.kumaran.SeleniumFramework.AbstractComponents.AbstractComponet;

public class CartPage extends AbstractComponet {

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//the item added in the cart is equal to the our cart product checking
//	List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
//	boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));

	
	@FindBy(css=".cartSection h3")
	private List<WebElement> producttitles;
	
	//checkout page
    //driver.findElement(By.cssSelector(".totalRow button")).click();
	@FindBy(css=".totalRow button")
	WebElement checkoutele;
	
	public boolean verifyProducts(String productName) {
	     return producttitles.stream()
	    		 .anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
	}

	public CheckoutPage gotocheckout() {
		checkoutele.click();
		CheckoutPage checkout = new CheckoutPage(driver);
		return checkout;
		
	}
}
