package driver_init;

import org.openqa.selenium.WebDriver;

public class Driver_Initialization {
	
private static String browser="Chrome";
private static WebDriver driver;
	
	
	public static WebDriver browserInitialization()
	{
		
		Driver_Definition def = new Driver_Definition();
		if(browser.equals("Chrome"))
		{
			driver = def.chromeDriverInitialization();
		}
		
		else if (browser.equals("firefox"))
		{
			driver = def.firefoxDriverInitialization();
		}
		
		else
		{
			System.out.println("No browser Initialized");
		}
		
		return driver;
	}

}
