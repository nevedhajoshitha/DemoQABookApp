package BasePackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	static ExtentReports extent;
	
	public static ExtentReports getReport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("target/ExtentReport.html");
		reporter.config().setReportName("Demoqa Report");
		reporter.config().setDocumentTitle("Sample Report Demoqa");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		return extent;
	}
}
