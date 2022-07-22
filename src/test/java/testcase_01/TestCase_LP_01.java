package testcase_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentReporter;


import Base.com.BassClassAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_LP_01 extends BassClassAll {

	WebDriver driver;
	ExtentTest TCase;
	ExtentReports Er;
	ExtentHtmlReporter Err;

	@BeforeSuite
	private void beforeLoad() {
		// TODO Auto-generated method stub
		Er = new ExtentReports();
		Err = new ExtentHtmlReporter("TestCase_LP_01.html");
		Er.attachReporter(Err);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterSuite
	private void afterLoad() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(60000);
		driver.quit();

	}

	@Test
	private void CheckCurrent_01() {

		// verify the Google page element

		TCase = Er.createTest("MyFirstTest").pass("verify the Google page element");

		driver.get("https://www.google.in");

		WebElement currentPage = driver.findElement(By.tagName("body"));
		String text = currentPage.getText();

		text.contains("Google");
		System.out.println(text);
		Assert.assertTrue(text.contains("Gogle") || text.contains("Gmail"));

		// check whether the Google image is present or not
		WebElement checkimg = driver.findElement(By.tagName("img"));
		String attribute = checkimg.getAttribute("alt");
		System.out.println(attribute);

	}

	

	@DataProvider(name = "login_adactin")
	private String[][] login() {
		return new String[][] { { "manojkumar", "manoj506" }, { "username", "password" },
				{ "reach2manoj506@gmail.com", "manoj506" } };
		// TODO Auto-generated method stub

	}

	@Test(dataProvider="login_adactin")
	private void login_Cred_LP_02(String user,String passwd) {

		// verify the Email page and Credentials
		TCase = Er.createTest("Mysecond").pass("verify the Google page element");
		driver.get("http://adactinhotelapp.com/");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(user);

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(passwd);

		WebElement login = driver.findElement(By.id("login"));
		login.click();

		

	}

	@Test
	private void veriftpage_03() {
		// Verify the Gmail page
		TCase = Er.createTest("Mythird").pass("verify the Google page element");
		driver.get("https://mail.google.com");
		String curtitle = driver.getTitle();
		Assert.assertEquals(curtitle, "Gmail");

	}

}
