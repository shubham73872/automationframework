package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import driver_init.Driver_Initialization;
import utilities.Excel_Utilities;
import utilities.Property_Reader;
import utilities.Utility_Methods;

public class Base_Class {

public WebDriver driver;
	
	public Utility_Methods um= null;
	
@BeforeMethod
public void beforeTest()
{
	
	driver = Driver_Initialization.browserInitialization();
	um = new Utility_Methods(driver);
}

@AfterMethod
public void afterTest()
{
	driver.quit();
}

@BeforeSuite
public void beforeSuite() throws IOException
{
	Property_Reader.loadPropertyFile();
	Excel_Utilities.readExcelFile();
}

}
