package com.kumaran.SeleniumFramework.pageFactory;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.kumaran.SeleniumFramework.AbstractComponents.AbstractComponet;

public class productCateloge extends AbstractComponet {

	WebDriver driver;
	
	public productCateloge(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

		
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	//pagefactory intilization
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	//driver.findElement(By.cssSelector(".ng-animating"))
	//pagefactory intilization
	@FindBy(css=".ng-animating")
	WebElement lodersymbol;
	By productlist=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastmessage=By.cssSelector("#toast-container");
	
    public List<WebElement> getProductlist() {  
		   waitforelementToAppear(productlist);
		   return products;
	   }
   
   public WebElement getProductByName(String productName) {
		//find in css selector for specific product
		WebElement prod1 = getProductlist().stream()
		.filter(product->
		product.findElement(By.cssSelector("b"))
		.getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod1;
   }
   

   public void addProductToCart(String productName) {
	 WebElement prod1=getProductByName(productName);
	   prod1.findElement(addToCart).click();
	   waitforelementToAppear(toastmessage);
	   waitforElementDisappear(lodersymbol);
   }
	

}
