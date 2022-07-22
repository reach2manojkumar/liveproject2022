package com.liveproject.actiondriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.liveproject.actioninterface.ActioninterClass;
import com.liveproject.baseclass.BaseClass;

public class Action extends BaseClass implements ActioninterClass {

	@Override
	public void ScrollByVisibleOfElement(WebDriver driver, WebElement ele) {

		// ScrollIntoView
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

	@Override
	public void moveClick(WebDriver driver, WebElement ele) {
		// move cusor and click
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();

	}

	@Override
	public boolean isfindElement(WebDriver driver, WebElement ele) {
		boolean flag=false;
		
		try {
			flag=ele.isDisplayed();
		}catch(Exception e){
			flag=false;
		}finally {
			if(flag) {
				System.out.println("Element found");
			}else {
				System.out.println("Element not found");
			}
		}

		return flag;
	}
	
	
}
