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
	public By errorMsg = By.cssSelector("ul[class='woocommerce-error'] strong");
	public By successMsg = By.cssSelector("div[class='woocommerce-MyAccount-content']");
	public By logoutButton = By.xpath("//a[contains(text(), 'Log out')]");
	
	
	public void loginInApp(String user, String pass) {
		
		sendKeys(userField, user);
		sendKeys(passwordField, pass);
		click(loginButton);
		
	}

}
