package driver_init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver_Definition {
	
	private WebDriver driver;

	public WebDriver chromeDriverInitialization() {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;

	}
	
	public WebDriver firefoxDriverInitialization() {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.gecko.driver", "E:\\drivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;

	}
	
	
	public WebDriver getDriver(){
		
		return driver;
	}

}
