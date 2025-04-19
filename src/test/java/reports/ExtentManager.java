package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public synchronized static ExtentReports getExtentReports() {
		if (extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
			spark.config().setDocumentTitle("Automation Test Report");
			spark.config().setReportName("SauceDemo Automation");
			extent = new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("Tester", "Muhammad Ihsan");
			extent.setSystemInfo("Environment", "QA");
		}
		
		return extent;
	}

}
