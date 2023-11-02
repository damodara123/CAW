package com.Execution;

import java.time.Duration;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.CommonFunctionalities.*;
import com.Pages.TablePage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestPgExe extends TablePage{
	
	ExtentReport er = new ExtentReport("TablePage");
	private ExtentTest report;
	boolean result;
	
	@BeforeClass
	public void Login() throws Exception 
	{
		report = er.createTest("Verify Open Browser");
		driver=lunchUrl();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		result = driver != null;
		er.logResults(result, driver, report, "OpenBrowser", "Browser opened successfully", "Failed to open Browser");	
		
	}
	
	@Test(priority = 1)
	public void TableDataButton()
	{
		report = er.createTest("Click on Table Data Button");
		buttonClick();
	}
	
	@Test(priority = 2)
	public void InsertData()
	{
		report = er.createTest("Sending the data from the table");
		TextBox();
	}
	
	@Test(priority = 3)
	public void RefBtn()
	{
		report = er.createTest("Click on the refresh button");
		BtnClick();
		delay(3);
		tabledata();
	}
	
	@AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if(result.getStatus() == ITestResult.FAILURE) {
            report.log(Status.FAIL,result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
        	report.log(Status.PASS, result.getTestName());
        }
        else {
        	report.log(Status.SKIP, result.getTestName());
        }
    }

@AfterTest
public void endReport()
{
	er.flush();		
}

}
