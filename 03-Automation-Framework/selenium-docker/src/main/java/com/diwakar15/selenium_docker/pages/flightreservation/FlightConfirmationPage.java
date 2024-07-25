package com.diwakar15.selenium_docker.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.diwakar15.selenium_docker.pages.AbstractPage;

public class FlightConfirmationPage extends AbstractPage{
	
	
	private static final Logger log = LoggerFactory.getLogger(FlightConfirmationPage.class);
	
	
	
	@FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(1) .col:nth-child(2)")
	private WebElement flightConfirmationElement;
	
	@FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(3) .col:nth-child(2)")
	private WebElement totalPriceElement;

	public FlightConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(flightConfirmationElement));
		return this.flightConfirmationElement.isDisplayed();
	}

		
	public String getPrice() {
		
		String confirmation = this.flightConfirmationElement.getText();
		String price = this.totalPriceElement.getText();
		
		log.info("Flight Confirmaion# : {}", confirmation);
		log.info("Total Price : {}", price);
		
		return price;
	} 
	
	
}
