package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class MyAccountPage extends SeleniumWrappers{

	public MyAccountPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	public By userField = By.id("username");
	public By passwordField = By.id("password");
	public By loginButton = By.cssSelector("button[name='login']");
	
	
	public void loginInApp(String user, String pass) {
		
		sendKeys(userField, user);
		sendKeys(passwordField, pass);
		click(loginButton);
		
	}

}
