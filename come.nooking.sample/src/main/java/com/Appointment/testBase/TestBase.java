package com.Appointment.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

	public static WebDriver driver;
	public static WebDriverWait oWait;
	public static Properties oProp;

	public static String propertyfile(String keys) {

		try {
			FileInputStream propReader = new FileInputStream(
					System.getProperty("user.dir") + "/Resources/config.properties");
			oProp = new Properties();
			try {
				oProp.load(propReader);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch blockFS
			e.printStackTrace();
		}
		
		//initialize();
		return oProp.getProperty(keys);
	}


	public static void browserSettings() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		System.out.println("browser was launced");
		
	}

	public void teardown() {
		driver.quit();

	}
}
