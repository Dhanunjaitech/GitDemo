package dhanunjaitech.Resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReporterNG {

	public static ExtentReports getReportObject()
	{

		String path = System.getProperty("user.dir")+"//reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		//manipulate reporting file
		reporter.config().setReportName("Web Automation Resuolts");
		reporter.config().setDocumentTitle("Test Results");
		
		
		// Extent Reports which is reporting all the results
		ExtentReports	 extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Dhanunjai Gandreddi");
		return extent;
		
		
				
		
	}

}
