package com.diwakar15.selenium_docker.tests.vendorportal;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.diwakar15.selenium_docker.pages.vendorportal.DashboardPage;
import com.diwakar15.selenium_docker.pages.vendorportal.LoginPage;
import com.diwakar15.selenium_docker.pages.vendorportal.LogoutPage;
import com.diwakar15.selenium_docker.tests.AbstractTest;

public class VendorPortalTest extends AbstractTest {

	private LoginPage loginPage;
	private DashboardPage dashboardPage;

	@BeforeTest
	public void setPageObjects() {

		this.loginPage = new LoginPage(driver);
		this.dashboardPage = new DashboardPage(driver);
	}

	@Test
	public void loginTest() {
		// LoginPage loginPage = new LoginPage(driver);
		loginPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
		Assert.assertTrue(loginPage.isAt());
		loginPage.login("sam", "sam");
	}

	@Test(dependsOnMethods = "loginTest")
	public void dashboardPage() {
		// DashboardPage dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.isAt());

		Assert.assertEquals(dashboardPage.getMonthlyEarning(), "$40,000");
		Assert.assertEquals(dashboardPage.getAnnualEarning(), "$215,000");
		Assert.assertEquals(dashboardPage.getProfitMargin(), "50%");
		Assert.assertEquals(dashboardPage.getAvailableInventory(), "18");

		dashboardPage.searchOrderHistory("adams");
		Assert.assertEquals(dashboardPage.getSearchResultsCount(), 8);

	}

	@Test(dependsOnMethods = "dashboardPage")
	public void logoutPage() {
		LogoutPage logoutPage = new LogoutPage(driver);
		Assert.assertTrue(logoutPage.isAt());
		logoutPage.logout();
		Assert.assertTrue(loginPage.isAt());
	}

}
