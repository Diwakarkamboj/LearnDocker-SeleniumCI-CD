package com.diwakar15.selenium_docker.tests.flightreservation;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.diwakar15.selenium_docker.pages.flightreservation.FlightConfirmationPage;
import com.diwakar15.selenium_docker.pages.flightreservation.FlightsSearchPage;
import com.diwakar15.selenium_docker.pages.flightreservation.FlightsSelectionPage;
import com.diwakar15.selenium_docker.pages.flightreservation.RegistrationConfirmationPage;
import com.diwakar15.selenium_docker.pages.flightreservation.RegistrationPage;
import com.diwakar15.selenium_docker.tests.AbstractTest;

public class FlightReservationTest extends AbstractTest {

	private String noOfPassangers;
	private String expectedPrice;

	@Parameters({ "noOfPassangers", "expectedPrice" })
	@BeforeTest
	public void setParameters(String noOfPassangers, String expectedPrice) {
		this.noOfPassangers = noOfPassangers;
		this.expectedPrice = expectedPrice;

	}

	@Test
	public void userRegistrationTest() {

		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html#");
		Assert.assertTrue(registrationPage.isAt());

		registrationPage.enterUserDetails("Ajay", "Sharma");
		registrationPage.enterUserCredentials("Ajay@gmail.com", "Docker");
		registrationPage.enterUserAddress("63 Whiteman St", "Melbourne", "3006");
		registrationPage.register();

	}

	@Test(dependsOnMethods = "userRegistrationTest")
	public void registrationConfirmationTest() {

		RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
		Assert.assertTrue(registrationConfirmationPage.isAt());

		registrationConfirmationPage.clkGoToFlightsSearchBtn();
	}

	@Test(dependsOnMethods = "registrationConfirmationTest")
	public void flightSearchTest() {

		FlightsSearchPage flightSearchPage = new FlightsSearchPage(driver);
		Assert.assertTrue(flightSearchPage.isAt());

		flightSearchPage.selectPassangers(noOfPassangers);
		flightSearchPage.searchFlightsBtn();

	}

	@Test(dependsOnMethods = "flightSearchTest")
	public void flightSelectionTest() {

		FlightsSelectionPage flightSelectionPage = new FlightsSelectionPage(driver);
		Assert.assertTrue(flightSelectionPage.isAt());

		flightSelectionPage.selectFlights();
		flightSelectionPage.confirmFlightBtn();
	}

	@Test(dependsOnMethods = "flightSelectionTest")
	public void flightReservationConfirmationTest() {

		FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
		Assert.assertTrue(flightConfirmationPage.isAt());

		Assert.assertEquals(flightConfirmationPage.getPrice(), expectedPrice);

	}

}
