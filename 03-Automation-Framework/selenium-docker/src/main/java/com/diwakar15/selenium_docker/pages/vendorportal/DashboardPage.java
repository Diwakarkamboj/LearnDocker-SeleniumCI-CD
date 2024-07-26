package com.diwakar15.selenium_docker.pages.vendorportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.diwakar15.selenium_docker.pages.AbstractPage;

public class DashboardPage extends AbstractPage{
	
	private static final Logger log = LoggerFactory.getLogger(DashboardPage.class);

	@FindBy(id = "monthly-earning")
	private WebElement monthlyEarning;
	
	@FindBy(id = "annual-earning")
	private WebElement annualEarning;
	
	@FindBy(id = "profit-margin")
	private WebElement profitMargin;
	
	@FindBy(id = "available-inventory")
	private WebElement availableInventory;
	
	@FindBy(css = "#dataTable_filter input")
	private WebElement searchInput;
	
	@FindBy(id = "dataTable_info")
	private WebElement searchResultsCountElement;
	
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(monthlyEarning));
		return this.monthlyEarning.isDisplayed();
	}
	
	public String getMonthlyEarning() {
		return this.monthlyEarning.getText();
	}
	
	public String getAnnualEarning() {
		return this.annualEarning.getText();
	}
	
	public String getProfitMargin() {
		return this.profitMargin.getText();
	}
	
	public String getAvailableInventory() {
		return this.availableInventory.getText();
	}
	
	public void searchOrderHistory(String keyword) {
		this.searchInput.sendKeys(keyword);
	}
	
	public int getSearchResultsCount() {
		 String resultsText = this.searchResultsCountElement.getText();
		 String[] arr = resultsText.split(" ");
		 int count = Integer.parseInt(arr[5]);
		 log.info("Results Count: {}", count);
		 return count;
	}
	
	

}
