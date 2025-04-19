package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test
	public void testValidLogin() {
		loginPage.login("standard_user", "secret_sauce");

		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.contains("inventory.html"));
	}

	@Test
	public void testInvalidLogin() {
		loginPage.login("invalid_user", "wrong_password");

		String error = loginPage.getErrorMessage();
		assertTrue(error.contains("Username and password do not match"), "Error message not as expected" + error);
	}

	@Test
	public void testLoginAndVerifyInventoryPage() {
		loginPage.login("standard_user", "secret_sauce");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

		Assert.assertEquals(productTitle.getText(), "Products");

		List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[contains(text(), 'Add to cart')]"));
		assertTrue(addToCartButtons.size() > 0, "No 'Add to cart' button found!");

	}

	@Test(dataProvider = "loginCredentials", dataProviderClass = testdata.LoginDataProvider.class)
	public void testLoginWithMultipleCredentials(String username, String password) {
		loginPage.login(username, password);

		if (username.equals("standard_user")) {
			assertTrue(driver.getCurrentUrl().contains("inventory.html"));
		} else {
			String error = loginPage.getErrorMessage();
			assertTrue(error.contains("Username and password do not match")
					|| error.contains("Sorry, this user has been locked out."));
		}
	}

	@Test(dataProvider = "loginExcelData", dataProviderClass = testdata.LoginDataProvider.class)
	public void testLoginWithExcelData(String username, String password) {
		loginPage.login(username, password);

		if ("standard_user".equals(username)) {
			assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Expected inventory page for " + username);
		} else {
			String err = loginPage.getErrorMessage();
			assertTrue(err.contains("Username and password do not match") || err.contains("locked out"),
					"Unexpected error for " + username + ": " + err);
		}
	}

}
