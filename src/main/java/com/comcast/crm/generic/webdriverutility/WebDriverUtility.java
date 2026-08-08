package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//for Switch Tab
	public void switchToTabURL(WebDriver driver,String parailURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actURL = driver.getCurrentUrl();
			if(actURL.contains(parailURL)) {
				break;
			}
		}
	}
	
	public void switchToTabOnTitle(WebDriver driver, String paratailTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it1 = set.iterator();
		while(it1.hasNext()) {
			String windowID = it1.next();
			driver.switchTo().window(windowID);
			String actTitle = driver.getTitle();
			if(actTitle.equals(paratailTitle)) {
				break;
			}
		}
	}
	
	//switch to Fram
	public void switchToFram(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFram(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	//Switch to Alert
	public void switchToAlterAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	//DropDowns
	public void Select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void Select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	//Action Class
	public void mouseMoveOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
}
