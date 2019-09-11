package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerator {
	
	 public WebDriver driver;
	 public ExtentHtmlReporter htmlReporter;
	 public ExtentReports extent;
	 public ExtentTest logger;

	 
	public void startReport() {
		 htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
		         // Create an object of Extent Reports
		 extent = new ExtentReports();  
		 extent.attachReporter(htmlReporter);
		 extent.setSystemInfo("Host Name", "Shubham PC");
		         extent.setSystemInfo("Environment", "QA");
		 extent.setSystemInfo("User Name", "Shubham");
		 htmlReporter.config().setDocumentTitle("Automation Report"); 
		                // Name of the report
		 htmlReporter.config().setReportName("Automation Framework Report"); 
		                // Dark Theme
		 htmlReporter.config().setTheme(Theme.STANDARD); 
		 }
	
	
	//This method is to capture the screenshot and return the path of the screenshot.
	 public String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
	 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 TakesScreenshot ts = (TakesScreenshot) driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	 // after execution, you could see a folder "FailedTestsScreenshots" under src folder
	 String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
	 File finalDestination = new File(destination);
	 FileUtils.copyFile(source, finalDestination);
	 return destination;
	 }
	 
	 public void createTest(String test)
	 {
		 logger = extent.createTest(test);
	 }
	 
	 
	 public void getResult(ITestResult result) throws Exception{
		 if(result.getStatus() == ITestResult.FAILURE){
		 //MarkupHelper is used to display the output in different colors
		 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		 //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
		 //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method. 
		 //String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
		 String screenshotPath = getScreenShot(driver, result.getName());
		 //To add it in the extent report 
		 logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
		 }
		 else if(result.getStatus() == ITestResult.SKIP){
		 logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); 
		 } 
		 else if(result.getStatus() == ITestResult.SUCCESS)
		 {
		 logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		 }
		 
		 }
	 
	 public void endReport() {
		 extent.flush();
		 }
	 
}
