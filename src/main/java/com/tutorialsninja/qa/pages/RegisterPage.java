package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameText;

	@FindBy(id = "input-lastname")
	private WebElement lastNameText;

	@FindBy(id = "input-email")
	private WebElement emailText;

	@FindBy(id = "input-telephone")
	private WebElement telephoneText;

	@FindBy(id = "input-password")
	private WebElement passwordText;

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmText;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyCheckBox;

	@FindBy(xpath = "//input[@name='newsletter'][@value=1]")
	private WebElement newsLetterYesRadio;

	@FindBy(xpath = "//input[@name='newsletter'][@value=0]")
	private WebElement newsLetterNoRadio;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement accountCreatedSuccessMessage;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement alreadyEmailExistWarningMessage;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarningMessage;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningMessage;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarningMessage;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningMessage;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMessage;

	public void enterFirstName(String firstName) {
		firstNameText.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameText.sendKeys(lastName);
	}

	public void enterEmail(String email) {
		emailText.sendKeys(email);
	}

	public void enterTelephone(String telephone) {
		telephoneText.sendKeys(telephone);
	}

	public void enterPassword(String password) {
		passwordText.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		passwordConfirmText.sendKeys(confirmPassword);
	}

	public void checkPrivacyPolicy() {
		privacyPolicyCheckBox.click();
	}

	public void selectNewsLetterYesRadio() {
		newsLetterYesRadio.click();
	}

	public void selectNewsLetterNoRadio() {
		newsLetterNoRadio.click();
	}

	public void clickContinue() {
		continueButton.click();
	}

	public String getAccountCreatedSuccessMessage() {
		return accountCreatedSuccessMessage.getText();
	}

	public String getAlreadyEmailExistWarningMessage() {
		return alreadyEmailExistWarningMessage.getText();
	}

	public String getPrivacyPolicyWarningMessage() {
		return privacyPolicyWarningMessage.getText();
	}

	public String getFirstNameWarningMessage() {
		return firstNameWarningMessage.getText();
	}

	public String getLastNameWarningMessage() {
		return lastNameWarningMessage.getText();
	}

	public String getEmailWarningMessage() {
		return emailWarningMessage.getText();
	}

	public String getTelephoneWarningMessage() {
		return telephoneWarningMessage.getText();
	}

	public String getPasswordWarningMessage() {
		return passwordWarningMessage.getText();
	}
	
	public void enterMandatoryFields(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
		firstNameText.sendKeys(firstName);
		lastNameText.sendKeys(lastName);
		emailText.sendKeys(email);
		telephoneText.sendKeys(telephone);
		passwordText.sendKeys(password);
		passwordConfirmText.sendKeys(confirmPassword);
		privacyPolicyCheckBox.click();
		//continueButton.click();
		
	}
	
	public void enterAllFields(String firstName, String lastName, String email, String telephone, String password, String confirmPassword) {
		firstNameText.sendKeys(firstName);
		lastNameText.sendKeys(lastName);
		emailText.sendKeys(email);
		telephoneText.sendKeys(telephone);
		passwordText.sendKeys(password);
		passwordConfirmText.sendKeys(confirmPassword);
		newsLetterYesRadio.click();
		privacyPolicyCheckBox.click();
		//continueButton.click();
		
	}

}
