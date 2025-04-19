package reports;

import java.io.File;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.DriverFactory;

public class TestListener implements ITestListener {
	private static ExtentReports extent = ExtentManager.getExtentReports();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest t = extent.createTest(result.getMethod().getMethodName());
		test.set(t);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().pass("Test passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.get().fail(result.getThrowable());
		try {
			File src = ((TakesScreenshot) DriverFactory.getDriver())
					.getScreenshotAs(OutputType.FILE);
			String path = "target/screenshots/" + result.getMethod().getMethodName() + ".png";
			Files.createDirectories(new File("target/screenshots").toPath());
			Files.copy(src.toPath(), new File(path).toPath());
			test.get().addScreenCaptureFromPath(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
