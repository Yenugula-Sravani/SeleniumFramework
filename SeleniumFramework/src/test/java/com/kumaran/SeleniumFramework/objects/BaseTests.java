package com.kumaran.SeleniumFramework.objects;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.kumaran.SeleniumFramework.pageFactory.Landingpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {

	static WebDriver driver;

	public static WebDriver intilizeDriver() throws IOException {
		// properties class
		Properties props = new Properties();
		FileInputStream filepath = new FileInputStream("C://Users//YenugulaSravani//eclipse-workspace//SeleniumFramework//src//main//java//com//kumaran//SeleniumFramework//resources//GlobalData.properties");
		props.load(filepath);
		String browserName = props.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.out.println("firefox is running");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("microsoft edge")) {
			System.out.println("edge is running");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public static Landingpage launchApplication() throws IOException {
		 driver = intilizeDriver();
          Landingpage page= new Landingpage(driver);
		  page.goTo();
		  return page;	
	}
	

	
}
