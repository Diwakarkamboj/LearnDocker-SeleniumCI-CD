package com.diwakar15.selenium_docker.pages.vendorportal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.diwakar15.selenium_docker.pages.AbstractPage;

public class LogoutPage extends AbstractPage{
	
	
	@FindBy(css = "img.img-profile")
	private WebElement userProfilePictureElement;
	
	@FindBy(xpath = "//*[@data-target='#logoutModal']") //css = "li.nav-item.dropdown.no-arrow.show > div > a:nth-child(5)"
	private WebElement logoutLink;
	
	@FindBy(css = "#logoutModal a")
	private WebElement modalLogoutButton;
	
	public LogoutPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public boolean isAt() {
		this.wait.until(ExpectedConditions.visibilityOf(userProfilePictureElement));
		return this.userProfilePictureElement.isDisplayed();
	}
	
	
	public void logout() {
		this.userProfilePictureElement.click();
		this.wait.until(ExpectedConditions.visibilityOf(logoutLink));
		this.logoutLink.click();
		this.wait.until(ExpectedConditions.visibilityOf(modalLogoutButton));
		this.modalLogoutButton.click();
	}

}
