package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniumWrappers extends BaseTest{
	
	public SeleniumWrappers (WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void hoverElement(By locator) {
		
		Actions action = new Actions(driver);
		action.moveToElement(returnWebElement(locator)).perform();
		
	}
	
	
	public void dragAndDrop(By locator, int x, int y) {
		
		Actions action = new Actions(driver);
		//action.dragAndDropBy(null, 0, 0).perform();
		action.clickAndHold(returnWebElement(locator)).moveByOffset(x, y).release().perform();
		
		
	}
	
	public void scrollVertically(int y) {
		
		Actions action = new Actions(driver);
		action.scrollByAmount(0, y).perform();
	}
	
	public void scrollHorizontally(int x) {
		
		Actions action = new Actions(driver);
		action.scrollByAmount(x, 0).perform();
	}

	public void click(By locator) {
		
		WebElement element = returnWebElement(locator);
		try { 
			
			waitForElementToBeClickable(locator);
			element.click();
			
		}catch(StaleElementReferenceException e) {
			
			element =returnWebElement(locator);
			element.click();
			
		}catch(Exception e) {
			
			//Log.error(e.getMessage());
			throw new TestException("Element not found in <click>");
			
		}
		
	}
	
	public void waitForElementToBeClickable(By locator) {
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			
			
		}catch(Exception e) {
			
			//Log.error(e.getMessage());
			throw new TestException("Element not found in <waitForElementToBeClickable> after 10 seconds");
			
		}
		
	}
	
	
	public void sendKeys(By locator, String text) {
		
		WebElement element = returnWebElement(locator);
		waitForElementToBeVisible(locator);
		
		try {
			element.clear();
			element.sendKeys(text);
			
		}catch(Exception e) {
			
			//Log.error(e.getMessage());
			throw new TestException("Element not found in <sendKeys>");
			
		}
		
		
	}
	
	public WebElement returnWebElement (By locator) {
		
		waitForElementToBeVisible(locator);
		return driver.findElement(locator);
	
	}
	
	public List<WebElement> returnWebElements(By locator) {
		return driver.findElements(locator);
	}

	
	public void waitForElementToBeVisible(By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
}
