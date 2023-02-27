package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingHomePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement MyAccountDropMenu;
	
	@FindBy(linkText = "Login")
	private WebElement LoginLink;
	
	@FindBy(linkText = "Register")
	private WebElement RegisterLink;
	
	public LandingHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyAccount() {
		MyAccountDropMenu.click();
	}
	
	public void clickOnLogin() {
		LoginLink.click();
	}
	
	public void clickOnRegister() {
		RegisterLink.click();
	}

}
