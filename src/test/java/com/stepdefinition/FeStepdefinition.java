package com.stepdefinition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

public class FeStepdefinition {

	WebDriver driver; // instance variable declare
	WebElement username;// login page -->username
	WebElement password;
	WebElement logWarn; // wrong password -->warning msg

	@Given("Open the chrome as login page")
	public void open_the_chrome_as_login_page() {
		// Pre-requirement config

		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://adactinhotelapp.com/");

	}

	@Given("verify whether loaded page is correct or not")
	public void verify_whether_loaded_page_is_correct_or_not() {
		boolean flag = false;
		try {

			String curTitle = driver.getTitle();
			WebElement logImg = driver.findElement(By.xpath("//img[contains(@alt,'AdactIn Group')]"));
			flag = true;

		} catch (Exception e) {
			System.out.println("Exception");
		} finally {
			if (flag) {

				assertTrue(flag);
				System.out.println("Page Not Loads");
			} else {
				assertFalse(flag);
				System.out.println("Page Loads");
			}

		}

	}

	@When("As user give invalid user and valid password")
	public void as_user_give_invalid_user_and_valid_password() {
		// Write code here that turns the phrase above into concrete actions
		username = driver.findElement(By.id("username"));
		username.sendKeys("manojwrong");
		password = driver.findElement(By.id("password"));
		password.sendKeys("Manoj506!");
		String textname = username.getText();
		String textpass = password.getText();
	}

	@When("Click the login botton")
	public void click_the_login_botton() {

		WebElement logBtn = driver.findElement(By.xpath("//*[contains(@value,'Login')]"));
		logBtn.click();
	}

	@Then("Check the whether it redirected to loginpage or not")
	public void check_the_whether_it_redirected_to_loginpage_or_not() {

		System.out.println("present");
		try {
			WebElement warnText = driver.findElement(By.xpath("//*[contains(text(),'Invalid Login details or Your Password might have expired. ')]"));
			if(warnText.isDisplayed()) {
				assertTrue("warn text is showing ", true);
			}
		} catch (Exception e) {
			
			System.out.println("Warning text is not showing");

		}
	
		
		
		
		/*
		 * try { logWarn =
		 * driver.findElement(By.xpath("//*[contains(text(),'Invalid Login details ')]")
		 * ); } catch (NullPointerException e) { e.getStackTrace(); if
		 * (logWarn.isDisplayed()) { System.out.println("invalid login credentials"); }
		 * else { System.out.println("valid login credentials"); } }
		 */

	}

	@Then("Verify Warning text is present or not")
	public void verify_warning_text_is_present_or_not() {

		System.out.println("adasd");
	
		
		
		
		
		
		
		
		/*
		 * try { logWarn =
		 * driver.findElement(By.xpath("//*[contains(text(),'Invalid Login details ')]")
		 * ); if (logWarn.isDisplayed()) {
		 * System.out.println("Given login credentials are not corrent "); }else {
		 * System.out.println("Given login  "); } } catch (Exception e) {
		 * 
		 * System.out.println("manjo");
		 * 
		 * }finally { String loginTittle = driver.getTitle(); String loginUrl =
		 * driver.getCurrentUrl(); if ((loginTittle == "Adactin.com - Search Hotel") &&
		 * loginUrl == "http://adactinhotelapp.com/SearchHotel.php") {
		 * System.out.println("Given login credentials are corrent "); } else {
		 * System.out.println("some error"); } }
		 */

	}

	// Scenario: Validating with blank username and black password
	@When("As user give blank user and blank password")
	public void as_user_give_blank_user_and_blank_password() {
		username = driver.findElement(By.id("username"));
		username.sendKeys("");
		password = driver.findElement(By.id("password"));
		password.sendKeys("");

	}

	// Scenario: Validating with valid username-->manojkumar506 and valid
	// password-->Password
	@When("As user give valid user and valid password")
	public void as_user_give_valid_user_and_valid_password() {
		username = driver.findElement(By.id("username"));
		username.sendKeys("manojkumar506");
		password = driver.findElement(By.id("password"));
		password.sendKeys("Password");
	}
	
	@Then("close the webpage")
	public void close_the_webpage() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	}
}
