package com.selenium.extent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Login 
{
	ExtentTest eTest;
	WebDriver driver;
	ExtentReports eReports;
	
	@Test
	public void loginTest()
	{
		String expTitle = "(49)Suprem Kamath";
		eReports = ExtentReportInstance.getExtentReportInstance();
		System.out.println(eReports);
		eTest = eReports.startTest("Test Login to app");
		
		eTest.log(LogStatus.INFO, "Launching the browser");
		driver = new ChromeDriver();
		
		eTest.log(LogStatus.INFO, "Setting the driver timeouts");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		eTest.log(LogStatus.INFO, "Maximize the browser");
		driver.manage().window().maximize();
		
		eTest.log(LogStatus.INFO, "Navigate to test app");
		driver.get("https:\\www.facebook.com");
		
		eTest.log(LogStatus.INFO, "Enter the UserName");
		driver.findElement(By.id("email")).sendKeys("neharane1994@rediffmail.com");
		
		eTest.log(LogStatus.INFO, "Enter the Password");
		driver.findElement(By.id("pass")).sendKeys("aaibaba");
		
		eTest.log(LogStatus.INFO, "Click on login button");
		driver.findElement(By.id("loginbutton")).click();
		
		eTest.log(LogStatus.INFO, "Navigate to test app");
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		
		if(actTitle.equals(expTitle))
		{
			eTest.log(LogStatus.PASS, "Exp and Act title is matching");
		}
		else
		{
			eTest.log(LogStatus.FAIL, "Exp and Act title is not matching");
		}
		
		//eTest.log(LogStatus.INFO, "Close the browser");
		eReports.flush();
		eReports.endTest(eTest);
		
		driver.quit();
	}
}