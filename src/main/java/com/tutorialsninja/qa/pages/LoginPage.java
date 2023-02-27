package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement userEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement userPassword;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;

	public void enterUserEmail(String email) {
		userEmail.clear();
		userEmail.sendKeys(email);
	}

	public void enterUserPassword(String password) {
		userPassword.clear();
		userPassword.sendKeys(password);
	}

	public void submitLogin() {
		loginButton.click();
	}

	public void login(String email, String password) {
		userEmail.clear();
		userEmail.sendKeys(email);
		userPassword.clear();
		userPassword.sendKeys(password);
		loginButton.click();
	}

	public String getMessageOfWarning() {
		return warningMessage.getText();
	}

}
