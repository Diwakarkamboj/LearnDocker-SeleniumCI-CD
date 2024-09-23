package com.diwakar15.selenium_docker.pages.flightreservation;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.diwakar15.selenium_docker.pages.AbstractPage;

public class RegistrationPage extends AbstractPage {

	@FindBy(id = "firstName")
	private WebElement firstNameInput;

	@FindBy(id = "lastName")
	private WebElement lastNameInput;

	@FindBy(id = "email")
	private WebElement emailInput;

	@FindBy(id = "password")
	private WebElement passwordInput;

	@FindBy(name = "street")
	private WebElement streetInput;

	@FindBy(name = "city")
	private WebElement cityInput;

	@FindBy(name = "zip")
	private WebElement zipInput;

	@FindBy(id = "register-btn")
	private WebElement registerBtn;

	public RegistrationPage(WebDriver driver) {

		super(driver);

	}
	
	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(firstNameInput));
		return this.firstNameInput.isDisplayed();
	}

	public void goTo(String url) {

		this.driver.get(url);

	}

	public void enterUserDetails(String firstName, String lastName) {

		this.firstNameInput.sendKeys(firstName);
		this.lastNameInput.sendKeys(lastName);
	}

	public void enterUserCredentials(String password, String email) {

		this.passwordInput.sendKeys(password);
		this.emailInput.sendKeys(email);
	}

	public void enterUserAddress(String street, String city, String zip) {

		this.streetInput.sendKeys(street);
		this.cityInput.sendKeys(city);
		this.zipInput.sendKeys(zip);
	}

	public void register() {	
		new Actions(driver).scrollToElement(registerBtn).perform();
		this.registerBtn.click();
		
	}
	
	

	

}
