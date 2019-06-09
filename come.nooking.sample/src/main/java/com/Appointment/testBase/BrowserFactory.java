package com.Appointment.testBase;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	static WebDriver driver;
	
	
	
	public BrowserFactory(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	public static WebDriver startBrowser() {
	String os =  System.getProperty("os.name").toLowerCase();
	
	 Map<String, Object> prefs = new HashMap<String, Object>();
	 prefs.put("profile.password_manager_enabled", true);     // This step will enable "Offer to save password" checkbox in chrome://settings.
	 ChromeOptions options = new ChromeOptions();
	// options.addArguments("user-data-dir=C:/Users/user_name/AppData/Local/Google/Chrome/User Data");
	 options.addArguments("test-type");
	 options.addArguments("start-maximized");
	 options.addArguments("--enable-automation");
	 options.addArguments("test-type=browser");
	 options.addArguments("disable-infobars");//
	 options.addArguments("--silent");//
	
	 
	  // This step will create a new profile at the given path.

	if (os.contains("mac")) {
		
		
	}
	
   System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/chromedriver");
    
  
	
	//options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");  

	driver = new ChromeDriver(options);
	
	return driver;
	
	}
	
}
