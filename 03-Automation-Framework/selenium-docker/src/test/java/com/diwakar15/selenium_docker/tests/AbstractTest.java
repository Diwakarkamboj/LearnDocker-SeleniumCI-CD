package com.diwakar15.selenium_docker.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.diwakar15.selenium_docker.listener.Listener;
import com.diwakar15.selenium_docker.util.Config;
import com.diwakar15.selenium_docker.util.Constants;
import com.google.common.util.concurrent.Uninterruptibles;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({Listener.class})
public abstract class AbstractTest {

	private static final Logger log = LoggerFactory.getLogger(AbstractTest.class);
	protected WebDriver driver;
	
	
	@BeforeSuite
	public void setupConfig() {
		Config.initialized();
	}

	@BeforeTest
//	@Parameters({"browser"}) TO CHANGE BROWSER FOR EVERY TEST
	//public void setDriver(String browser) throws MalformedURLException {
	public void setDriver(ITestContext ctx) throws MalformedURLException {

		this.driver = Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED)) ? getRemoteDriver() : getLocalDriver();
		ctx.setAttribute(Constants.DRIVER, this.driver);	
	}
	
	//	private WebDriver getRemoteDriver(String browser) throws MalformedURLException {
	private WebDriver getRemoteDriver() throws MalformedURLException {
		
		Capabilities capabilities = new ChromeOptions();
		if(Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER))) {
			
			capabilities = new FirefoxOptions();
		}
		
		String urlFormat = Config.get(Constants.GRID_URL_FORMAT);
		String hubHost = Config.get(Constants.GRID_HUB_HOST);
		String url = String.format(urlFormat, hubHost);
		
//		if(System.getProperty("browser").equalsIgnoreCase("chrome"))
//		//if(browser.equalsIgnoreCase("chrome"))
//		{
//			capabilities = new ChromeOptions();
//		}else 
//		{
//			capabilities = new FirefoxOptions();
//		}
		
		log.info("grid url: {}", url);
		
		return new RemoteWebDriver(new URL(url),capabilities);	
		
	}
	
	
	private WebDriver getLocalDriver() {
		WebDriverManager.chromedriver().browserVersion("127.0.6533.73").setup();
		return new ChromeDriver();	
		
	}

	@AfterTest
	public void quitDriver() {
		this.driver.quit();

	}
	
//	@AfterMethod
//	public void sleep() {
//		Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
//
//	}

}
