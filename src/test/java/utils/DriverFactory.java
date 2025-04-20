package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			
			try {
				Path userDir = Files.createTempDirectory("chrome-user-data-");
				options.addArguments("--user-data-dir" + userDir.toAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			options.addArguments("--remore-allow-origins=*");
			options.addArguments("windows-size=1920,1080");
			
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
