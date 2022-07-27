package com.liveproject.actioninterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActioninterClass {

	
	public void ScrollByVisibleOfElement(WebDriver driver,WebElement ele);
	public void moveClick(WebDriver driver,WebElement ele);
	
	
	
	
	//Title Method
	public String getCurrentURL(WebDriver driver);
	public String getTitle(WebDriver driver);
	
	//wait Method
	public void fluentWait(WebDriver driver,WebElement element, int timeOut);
	public void implicitWait(WebDriver driver, int timeOut);
	public void explicitWait(WebDriver driver, WebElement element, int timeOut);
	public void pageLoadTimeOut(WebDriver driver, int timeOut);
	
	
	//Assertion 
	public boolean isDisplayed(WebDriver driver, WebElement ele);
	public boolean type(WebElement ele, String text);
	
	public boolean isSelected(WebDriver driver, WebElement ele);
	public boolean isEnabled(WebDriver driver, WebElement ele);
	public boolean  isfindElement(WebDriver driver,WebElement ele);
	
	
	//Select method
	public boolean selectBySendkeys(String value,WebElement ele);
	public boolean selectByIndex(WebElement element, int index);
	public boolean selectByValue(WebElement element,String value);
	public boolean selectByVisibleText(String visibletext, WebElement ele);
	
	//js Click and mouse method
	public boolean mouseHoverByJavaScript(WebElement locator);
	public boolean JSClick(WebDriver driver, WebElement ele);
	
	//Iframe method
	public boolean switchToFrameByIndex(WebDriver driver,int index);
	public boolean switchToFrameById(WebDriver driver,String idValue);
	public boolean switchToFrameByName(WebDriver driver,String nameValue);
	public boolean switchToDefaultFrame(WebDriver driver);
	//Mouse Action
	public boolean moveToElement(WebDriver driver, WebElement ele);
	public boolean mouseover(WebDriver driver, WebElement ele);
	public boolean draggable(WebDriver driver,WebElement source, int x, int y);
	public boolean draganddrop(WebDriver driver,WebElement source, WebElement target);
	public void mouseOverElement(WebDriver driver,WebElement element);

	//Window switch 
	public boolean switchWindowByTitle(WebDriver driver,String windowTitle, int count);
	public boolean switchToNewWindow(WebDriver driver);
	public boolean switchToOldWindow(WebDriver driver);
	
	//Alert
	public boolean Alerta(WebDriver driver);
	public boolean launchUrl(WebDriver driver,String url);
	public boolean isAlertPresent(WebDriver driver);
	public boolean click1(WebElement locator, String locatorName);
	
	//get excel
	public int getColumncount(WebElement row);
	public int getRowCount(WebElement table);
	

	public boolean slider(WebDriver driver,WebElement ele, int x, int y);
	public boolean rightclick(WebDriver driver,WebElement ele);
	
	
	public String screenShot(WebDriver driver, String filename);
	public String getCurrentTime();
	
	
	
	
	
	
	
	
	
	
	
	
	

}
