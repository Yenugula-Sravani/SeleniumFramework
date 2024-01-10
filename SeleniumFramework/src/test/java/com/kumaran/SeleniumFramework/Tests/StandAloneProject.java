package com.kumaran.SeleniumFramework.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneProject {

	public static void main(String[] args) {
		String productName="zara coat 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("yenugula@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Sravani@123");
		driver.findElement(By.id("login")).click();
		//after clicking login,we should wait for 5seconds,so applying the explicit wait here
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		//find in css selector for specific product
		WebElement prod1 = products.stream()
		.filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		prod1.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//after clicking add to cart,we should wait for 5seconds,so applying the explicit wait here
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//ng-animating
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//clicking on the cart
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//the item added in the cart is equal to the our cart product checking
		
		List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		//checkout page
		driver.findElement(By.cssSelector(".totalRow button")).click();
		//handling auto suggestive box
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmedtxt = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(confirmedtxt);
		Assert.assertEquals(confirmedtxt.equals("THANKYOU FOR THE ORDER"), match);
		driver.close();
		
		

	}

}
