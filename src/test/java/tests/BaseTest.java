package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import pages.LoginPage;
import utils.DriverFactory;

@Listeners(reports.TestListener.class)
public class BaseTest {
	protected WebDriver driver;
	protected LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.getDriver();
		driver.get("https://www.saucedemo.com/");
		loginPage = new LoginPage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
