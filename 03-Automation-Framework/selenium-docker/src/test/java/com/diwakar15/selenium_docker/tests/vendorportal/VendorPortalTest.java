package com.diwakar15.selenium_docker.tests.vendorportal;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.diwakar15.selenium_docker.pages.vendorportal.DashboardPage;
import com.diwakar15.selenium_docker.pages.vendorportal.LoginPage;
import com.diwakar15.selenium_docker.pages.vendorportal.LogoutPage;
import com.diwakar15.selenium_docker.tests.AbstractTest;
import com.diwakar15.selenium_docker.tests.vendorportal.model.VendorPortalTestData;
import com.diwakar15.selenium_docker.util.Config;
import com.diwakar15.selenium_docker.util.Constants;
import com.diwakar15.selenium_docker.util.JsonUtil;

public class VendorPortalTest extends AbstractTest {

	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private VendorPortalTestData testData;

	@BeforeTest
	@Parameters("testDataPath")
	public void setPageObjects(String testDataPath) {

		this.loginPage = new LoginPage(driver);
		this.dashboardPage = new DashboardPage(driver);
		this.testData = JsonUtil.getTestData(testDataPath, VendorPortalTestData.class);
		
	}

	@Test
	public void loginTest() {
		// LoginPage loginPage = new LoginPage(driver);
		loginPage.goTo(Config.get(Constants.VENDOR_PORTAL_URL));
		Assert.assertTrue(loginPage.isAt());
		loginPage.login(testData.username(), testData.password());
	}

	@Test(dependsOnMethods = "loginTest")
	public void dashboardPage() {
		// DashboardPage dashboardPage = new DashboardPage(driver);
		Assert.assertTrue(dashboardPage.isAt());

		Assert.assertEquals(dashboardPage.getMonthlyEarning(), testData.monthlyEarning());
		Assert.assertEquals(dashboardPage.getAnnualEarning(), testData.annualEarning());
		Assert.assertEquals(dashboardPage.getProfitMargin(), testData.profitMargin());
		Assert.assertEquals(dashboardPage.getAvailableInventory(), testData.availableInventory());

		dashboardPage.searchOrderHistory(testData.searchKeyword());
		Assert.assertEquals(dashboardPage.getSearchResultsCount(), testData.searchResultCount());

	}

	@Test(dependsOnMethods = "dashboardPage")
	public void logoutPage() {
		LogoutPage logoutPage = new LogoutPage(driver);
		Assert.assertTrue(logoutPage.isAt());
		logoutPage.logout();
		Assert.assertTrue(loginPage.isAt());
	}

}
