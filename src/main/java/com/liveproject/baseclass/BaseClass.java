package com.liveproject.baseclass;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.liveproject.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;



public class BaseClass {

	// loadconfig
	public Properties prop;

	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driverT = new ThreadLocal<>();

	@BeforeSuite
	public void loadConfig() {
		ExtentManager.setEextent();
		
		

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "//configure//Baseconfi.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {

			e.getStackTrace();
			System.out.println("File not Found ");
		} catch (IOException e) {
			// TODO: handle exception
			e.getMessage();
			System.out.println(e.getMessage() + "IOexception");
		}
	}
	
	//Get Driver From ThreadLocal. (try in different method  )
	public static WebDriver getDriver() {
		return driverT.get();
	}
	
	
	public void lanuchApp(String Browser) {
		// TODO Auto-generated method stub
		if(Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driverT.set(new ChromeDriver());
			
		}
		else if(Browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driverT.set(new FirefoxDriver());
			
		}
		else if(Browser.equalsIgnoreCase("edge")) {
			WebDriverManager.iedriver().setup();
			driverT.set(new InternetExplorerDriver());
			
		}
		//To Maximize the screen 
		getDriver().manage().window().maximize();
		
		
		//TO Clear cookies 
		getDriver().manage().deleteAllCookies();
		
		
		//TO Implicate wait for  10 second 
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//TO pageLoadTime for 10 seconds 
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//launch Browser URL
		getDriver().get(prop.getProperty("url"));
		
	}
	
	
	@AfterSuite
	public void AfterSuite() {
		// TODO Auto-generated method stub
		ExtentManager.endReport();

	}

}
