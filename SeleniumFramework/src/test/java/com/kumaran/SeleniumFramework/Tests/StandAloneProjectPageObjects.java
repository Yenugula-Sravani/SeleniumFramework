package com.kumaran.SeleniumFramework.Tests;

import java.io.IOException;
import java.util.*;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.kumaran.SeleniumFramework.objects.BaseTests;
import com.kumaran.SeleniumFramework.pageFactory.*;

public class StandAloneProjectPageObjects extends BaseTests {
	String productName="zara coat 3";
	Landingpage landingpage ;
	
	@Test(dataProvider = "getData",groups = {"purchase","smoke"})
	public void submitOrder(HashMap<String, String> input) throws IOException {
		
		
        landingpage = launchApplication();
		productCateloge pc=landingpage.LoginApplication(input.get("email"), input.get("password"));
        List<WebElement> products = pc.getProductlist();
		pc.addProductToCart(input.get("productName"));
		CartPage cp= pc.gotocart();//can able to access parent class methods by child class object.	
	    boolean match = cp.verifyProducts(input.get("productName"));
	    Assert.assertTrue(match);
	    CheckoutPage checkout= cp.gotocheckout();    
		checkout.selectCountry("india");
		ConfirmationPage confirmationPage=checkout.submitOrder();		
		String msg = confirmationPage.getConfirmationMsg();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods = "")
	public void orderHistroy() {
		
		productCateloge pc=landingpage.LoginApplication("yenugula@gmail.com", "Sravani@123");
		orderPage orderPage = pc.gotoorderpage();
		Assert.assertTrue(orderPage.verifyProductsInOrders(productName));
	}
	
	//Agenda of the implementation parameterized into tests with testNg DataProvider
	@DataProvider
	public Object[][] getData() {
		//Integration of HashMap to DataProvider to send the data as one Hash object
		HashMap<String, String> map=new HashMap<>();
		map.put("email", "yenugula@gmail.com");
		map.put("password", "Sravani@123");
		map.put("productName","zara coat 3" );
		return new Object[][] {{map},{map}};
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
