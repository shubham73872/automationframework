package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver_init.Driver_Definition;

public class Utility_Methods {
	
	public Utility_Methods(WebDriver driver)
	{
		this.driver= driver;
	}
	
	 WebDriver driver;
	
	public void clickOperation(By element)
	{
		driver.findElement(element).click();
	}
	
	public  void sendKeysOperation(By element, String value)
	{
	driver.findElement(element).sendKeys(value);
	}
	
	public String getText(By element)
	{
		String str = driver.findElement(element).getText();
		
		return str;
	}
	
	public void explicitWaitForVisibility(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		
	}
	
	
}
