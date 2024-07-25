package com.diwakar15.selenium_docker.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.diwakar15.selenium_docker.pages.AbstractPage;

import net.bytebuddy.implementation.bind.annotation.Super;

public class RegistrationConfirmationPage extends AbstractPage{
	
	
	@FindBy(id = "go-to-flights-search")
	WebElement goToFlightsSearchBtn;
	
	
	
	public RegistrationConfirmationPage(WebDriver driver) {
		
		super(driver);
		
	}

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(this.goToFlightsSearchBtn));
		return this.goToFlightsSearchBtn.isDisplayed();
	}
	
	public void clkGoToFlightsSearchBtn() {
		
		this.goToFlightsSearchBtn.click();
	}


	
}
