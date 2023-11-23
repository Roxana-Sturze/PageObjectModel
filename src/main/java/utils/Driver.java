package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {

	//public WebDriver driver;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	
	public WebDriver initDriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			//driver = new ChromeDriver();
			
			driver.set(new ChromeDriver(getCromeOptions()));
			return driver.get();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
			//driver = new FirefoxDriver();
			
			driver.set( new FirefoxDriver(getFirefoxOptions()));
			return driver.get();
			
					
		}else if(browser.equalsIgnoreCase("edge")) {
			
			//driver = new EdgeDriver();
			
			driver.set(new EdgeDriver(getEdgeOptions()));
			return driver.get();
			
		}
		
		
		return driver.get();
		
	}
	
	public ChromeOptions getCromeOptions() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1580, 1280");
		return options;
		
	}
	
	public FirefoxOptions getFirefoxOptions() {
		
		FirefoxBinary binary = new FirefoxBinary();
		FirefoxOptions options = new FirefoxOptions();
		binary.addCommandLineOptions("--headless");
		options.setBinary(binary);
		return options;
	}
	
	public EdgeOptions getEdgeOptions() {
		
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1580, 1280");
		return options;
		
	}
	
}
