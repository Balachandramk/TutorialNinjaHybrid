package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText = "Edit your account information")
	private WebElement editYourAccountInformationLink;
	
	public boolean displayStatusOfEditYourAccountInformationLink() {
		boolean linkDisplayStatus = editYourAccountInformationLink.isDisplayed();
		return linkDisplayStatus;
	}

}
