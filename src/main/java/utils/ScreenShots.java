package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShots {
	
	public static void screenshot(WebDriver driver) throws IOException {
		
		TakesScreenshot file = (TakesScreenshot) driver;
		
		File picture = file.getScreenshotAs(OutputType.FILE);
		
		Files.copy(picture, new File("poze/screen.png") );
		
	}

}
