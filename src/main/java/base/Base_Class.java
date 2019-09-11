package base;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import driver_init.Driver_Initialization;
import utilities.Excel_Utilities;
import utilities.ExtentReportGenerator;
import utilities.Property_Reader;
import utilities.Utility_Methods;

public class Base_Class {

public WebDriver driver;
	
	public Utility_Methods um= null;
	public ExtentReportGenerator erp = null;
	
@BeforeMethod
public void beforeTest(Method name)
{
	
	driver = Driver_Initialization.browserInitialization();
	um = new Utility_Methods(driver);
	erp.createTest(name.getName());
}

@AfterMethod
public void afterTest(ITestResult result) throws Exception
{
	erp.getResult(result);
	driver.quit();
}

@BeforeSuite
public void beforeSuite() throws IOException
{
	Property_Reader.loadPropertyFile();
	Excel_Utilities.readExcelFile();
	erp = new ExtentReportGenerator();
	erp.startReport();
}

@AfterSuite
public void endReport()
{
	erp.endReport();
}
}
