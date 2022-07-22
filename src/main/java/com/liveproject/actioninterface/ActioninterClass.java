package com.liveproject.actioninterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActioninterClass {

	
	public void ScrollByVisibleOfElement(WebDriver driver,WebElement ele);
	public void moveClick(WebDriver driver,WebElement ele);
	
	
	public boolean  isfindElement(WebDriver driver,WebElement ele);
	
}
