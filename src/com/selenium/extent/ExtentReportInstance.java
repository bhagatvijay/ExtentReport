package com.selenium.extent;

import java.io.File;
import java.util.Date;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;


public class ExtentReportInstance 
{
	public static ExtentReports getExtentReportInstance() 
	{
		Date date = new Date();
		String currentDate = date.toString().replace(" ", "_").replace(":", "_");
		
		String filePath = "Reports\\"+currentDate+".html";
		System.out.println(filePath);
		
		ExtentReports eReport = new ExtentReports(filePath);
		File configFile = new File("Reports-Config.xml");
		eReport.loadConfig(configFile);
		eReport.addSystemInfo("Environment", "Win 10").addSystemInfo("Selenium", "3.141.5").addSystemInfo("TestNG", "7.0");
		
		return eReport;
	}

}
