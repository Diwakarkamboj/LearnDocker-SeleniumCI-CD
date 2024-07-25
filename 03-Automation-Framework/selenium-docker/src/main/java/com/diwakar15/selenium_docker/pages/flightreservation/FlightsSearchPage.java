package com.diwakar15.selenium_docker.pages.flightreservation;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.diwakar15.selenium_docker.pages.AbstractPage;

public class FlightsSearchPage extends AbstractPage{

	@FindBy(id = "passengers")
	private WebElement passangerSelect;
	
	@FindBy(id = "search-flights")
	private WebElement searchFlightsBtn;
	
	public FlightsSearchPage(WebDriver driver) {
		super(driver);
		
	}

	@Override
	public boolean isAt() {
		
		this.wait.until(ExpectedConditions.visibilityOf(passangerSelect));
		return this.passangerSelect.isDisplayed();
	}
	
	public void selectPassangers(String noOfPassangers) {
		Select passangers = new Select(this.passangerSelect);
		passangers.selectByValue(noOfPassangers);
	}
	
	
	public void searchFlightsBtn() {
		new Actions(driver).scrollToElement(searchFlightsBtn).perform();
		this.searchFlightsBtn.click();
		
	}
	
	

}
