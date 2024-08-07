package com.diwakar15.selenium_docker.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest {

	protected WebDriver driver;

	@BeforeTest
//	@Parameters({"browser"}) TO CHANGE BROWSER FOR EVERY TEST
	//public void setDriver(String browser) throws MalformedURLException {
	public void setDriver() throws MalformedURLException {
		if(Boolean.getBoolean("selenium.grid.enabled")) {
			//this.driver = getRemoteDriver(browser);
			this.driver = getRemoteDriver();
		}else
		{
			this.driver = getLocalDriver();
		}
	}
	
	//	private WebDriver getRemoteDriver(String browser) throws MalformedURLException {
	private WebDriver getRemoteDriver() throws MalformedURLException {
		
		Capabilities capabilities;
		
		if(System.getProperty("browser").equalsIgnoreCase("chrome"))
		//if(browser.equalsIgnoreCase("chrome"))
		{
			capabilities = new ChromeOptions();
		}else 
		{
			capabilities = new FirefoxOptions();
		}
		
		return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);	
		
	}
	
	
	private WebDriver getLocalDriver() {
		WebDriverManager.chromedriver().browserVersion("127.0.6533.73").setup();
		return new ChromeDriver();	
		
	}

	@AfterTest
	public void quitDriver() {
		this.driver.quit();

	}

}
