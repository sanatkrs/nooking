package com.booking.sample.come.nooking.sample;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Appointment.testBase.BrowserFactory;
import com.Appointment.testBase.TestBase;

public class appointment extends TestBase {
	
	static WebDriver driver;
	static Select select ;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println(System.getProperty("os.name"));

		bookApointment();
		
		
		
	}
	
	public static void bookApointment() throws InterruptedException, IOException {
		
		driver = BrowserFactory.startBrowser();
		driver.get("https://www.vfsglobalservices-germany.com/Global-Appointment/Account/");

		driver.findElement(By.id("EmailId")).sendKeys("sanatkumarsingh@yahoo.co.in");
		driver.findElement(By.id("Password")).sendKeys("SHanat@22");
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Schedule Appointment']")));
		
		Parent :for(int k=0;k<200;k++) {
			try {
			System.out.println("check number " + k);
		driver.findElement(By.xpath("//a[text()='Schedule Appointment']")).click();
		select = new Select(driver.findElement(By.id("VisaCategoryId")));
		select.selectByVisibleText("Job Seeker Visa");//Family Reunion Visa//
		select = new Select(driver.findElement(By.id("SubVisaCategoryId")));
		select.selectByVisibleText("Job Seeker");//Family Reunion//
		Thread.sleep(3000);
		
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.id("btnContinue")));
		driver.findElement(By.id("btnContinue")).sendKeys(Keys.ENTER);
	
		driver.findElement(By.xpath("//a[text()='Add Applicant']")).click();
		
		driver.findElement(By.id("PassportNumber")).sendKeys("l3693821");
	
		driver.findElement(By.id("DateOfBirth")).sendKeys("01/09/1989");
		
		driver.findElement(By.id("PassportExpiryDate")).sendKeys("25/08/2025");
		
		select = new Select(driver.findElement(By.id("NationalityId")));
	
		select.selectByVisibleText("INDIA");
		select = new Select(driver.findElement(By.id("GenderId")));
	
		select.selectByVisibleText("Male");
	
		driver.findElement(By.id("submitbuttonId")).click();

		driver.switchTo().alert().accept();//Continue
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Continue']")));
	
		driver.findElement(By.xpath("//input[@value='Continue']")).click();//
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.id("calendar")));
		
		WebElement dates;
		 List<WebElement> dateList ;
		
		
		for(int i = 0;i<8;i++) {
			
			
		 if(i!=0) {
			
			driver.findElement(By.xpath("//span[contains(@class,'fc-button fc-button-next')]")).click();;
		 }
		 dates = driver.findElement(By.xpath("//table//table/tbody"));	
	     dateList = dates.findElements(By.tagName("td"));	
			
	
		  for(WebElement d: dateList ) {
			
			String color = d.getCssValue("background-color");
			
			//System.out.println(color + " " + d.getText());
			if(color.equals("rgba(188, 237, 145, 1)")){
				
				d.click();
				new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.id("timeBandListTable1")));
				driver.findElement(By.xpath("//input[@name='selectedTimeBand']")).click();
				driver.findElement(By.id("btnConfirm")).click();
				driver.switchTo().alert().accept();
				System.out.println("Appointment Booked Hurrey!!");
				break Parent;
			}
			
		}
		}
		
		for(int J = 8;J>0;J--) {
			
			 if(J!=1) {
				
				driver.findElement(By.xpath("//span[contains(@class,'fc-button fc-button-prev')]")).click();;
			 }
			 dates = driver.findElement(By.xpath("//table//table/tbody"));	
		     dateList = dates.findElements(By.tagName("td"));	
				
		
			  for(WebElement d: dateList ) {
				
				String color = d.getCssValue("background-color");
				
				//System.out.println(color + " " + d.getText());
				if(color.equals("rgba(188, 237, 145, 1)")){
					
					d.click();
					new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.id("timeBandListTable1")));
					driver.findElement(By.xpath("//input[@name='selectedTimeBand']")).click();
					driver.findElement(By.id("btnConfirm")).click();
					driver.switchTo().alert().accept();
					new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Appointment Confirmation']")));
					
					System.out.println("Appointment Booked Hurrey!!");
					break Parent;
				}
				
			}
			}
		
		
	}
		catch(Exception e) {
			
			System.out.println(e.getStackTrace());
			continue;
		}
	}
		driver.quit();
		shutdown();
	}
	
	public static void shutdown() throws RuntimeException, IOException {
	    String shutdownCommand;
	    String operatingSystem = System.getProperty("os.name");

	    if ("Linux".equals(operatingSystem) || "Mac OS X".equals(operatingSystem)) {
	        shutdownCommand = "shutdown [-] [-h [-u] [-n] | -r [-n] | -s | -k] time [warning-message ...]";
	    }
	    else if ("Windows".equals(operatingSystem)) {
	        shutdownCommand = "shutdown.exe -s -t 0";
	    }
	    else {
	        throw new RuntimeException("Unsupported operating system.");
	    }

	    Runtime.getRuntime().exec(shutdownCommand);
	    System.exit(0);
	}
}
