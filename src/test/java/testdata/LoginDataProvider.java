package testdata;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class LoginDataProvider {
	
	@DataProvider(name = "loginCredentials")
	public Object[][] loginCredentials() {
		return new Object[][] {
			{"standard_user", "secret_sauce"},
			{"invalid_user", "wrong_password"},
			{"locked_out_user", "secret_sauce"}
		};
	}
	
	@DataProvider(name = "loginExcelData")
	public Object[][] loginExcelData() {
		String path = "src/test/resources/LoginData.xlsx";
		return ExcelUtils.readExcel(path, "Sheet1");
	}

}
