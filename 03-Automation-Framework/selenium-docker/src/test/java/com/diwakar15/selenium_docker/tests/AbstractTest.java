package com.diwakar15.selenium_docker.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest {

	protected WebDriver driver;

	@BeforeTest
	public void setDriver() {
		WebDriverManager.chromedriver().browserVersion("127.0.6533.73").setup();
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterTest
	public void quitDriver() {
		this.driver.quit();

	}

}
