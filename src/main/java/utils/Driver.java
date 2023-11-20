package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	public WebDriver driver;
	
	
	public WebDriver initDriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			return driver;
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			return driver;
			
					
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			return driver;
			
		}
		
		
		return driver;
		
	}
	
	
}
