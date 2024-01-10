package com.kumaran.SeleniumFramework.pageFactory;

import org.openqa.selenium.WebDriver;

import com.kumaran.SeleniumFramework.AbstractComponents.AbstractComponet;

public class closeDriver  extends AbstractComponet{

	WebDriver driver;
	
	public closeDriver(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	

	
	
}
