package testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base_Class;
import selectors.Login_Page_Selectors;
import utilities.Excel_Utilities;
import utilities.Property_Reader;
import utilities.Utility_Methods;

public class Test_Class extends Base_Class {
	
	@Test(dataProvider="getDataFromDataProvider")
	public void launchingFlipkart(String username,String password) throws IOException
	{
		
		if(Excel_Utilities.isTestCasePresent("LoginTest"))
		{
		driver.get(Property_Reader.getPropertyFromKey("URL"));
		
		//Utility_Methods.clickOperation(Login_Page_Selectors.loginSignUpBtn);
//		Utility_Methods.sendKeysOperation(Login_Page_Selectors.emailMobileNumber,Excel_Utilities.readDataFromSheets("Data", 1, 0));
		um.sendKeysOperation(Login_Page_Selectors.emailMobileNumber, username);
		um.sendKeysOperation(Login_Page_Selectors.password, password);
//		Utility_Methods.sendKeysOperation(Login_Page_Selectors.password,Excel_Utilities.readDataFromSheets("Data", 1, 1));
		
		um.clickOperation(Login_Page_Selectors.loginBtn);
		}
		
	}
	
	
	@DataProvider
	public Object[][] getDataFromDataProvider()
	{
		return(Excel_Utilities.readDataFromSheets());
	}
	

}
