package com.diwakar15.selenium_docker.listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.diwakar15.selenium_docker.util.Constants;

public class Listener implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		 TakesScreenshot driver = (TakesScreenshot) result.getTestContext().getAttribute(Constants.DRIVER);
		String Screenshot = driver.getScreenshotAs(OutputType.BASE64);
		String htmlImageFormat = "<img width=700px src='data:image/png;base64,%s' />";
		String htmlImage = String.format(htmlImageFormat, Screenshot);
		Reporter.log(htmlImage);
	}
	
	

}
