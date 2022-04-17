package com.payrollproject.utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	

	public static String getPageTitle(WebDriver driver)
	{
		return driver.getTitle();
	} 
	public static void Scroll(WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		jse.executeScript("scroll(250, 0)"); // if the element is on top.

		jse.executeScript("scroll(0, 250)");
	}
	public static void clickElement(JavascriptExecutor js,String script) {
		js.executeScript(script);
	}
	public static int getSizeOfElement(List<WebElement>element) {
		return element.size();
	}
	public static void enterText(WebElement element,String value)
	{
		element.sendKeys(value);
	}
	public static void enterNumericText(WebElement element, double d) {
		String s=String.valueOf(d);
		element.sendKeys(s);
	}
	
	public static void clickOnelement(WebElement element)
	{
		element.click();
	}
	public static String getElementText(WebElement element)
	{
		return element.getText();
	}

	public static boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}
	
	public static boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	public static boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}
	public static void selectDropdownbyText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public static void getElementClear(WebElement element)
	{
		element.clear();
	}
	public static List<WebElement> getDropdownOptions(Select select) {
		return select.getOptions();
	}
	public void selectDropdownOption(String element, Select select) {
		select.selectByValue(element);
	}
	public void selectDropdownIndex(String element, Select select) {
		select.selectByIndex(2);
	}
	public void dragAndDrop(WebElement source, WebElement target, Actions action) {
		action.dragAndDrop(source, target);
	}

	public void clickAndHold(WebElement element, Actions action) {
		action.clickAndHold(element);
	}
	
	
	

	
}
