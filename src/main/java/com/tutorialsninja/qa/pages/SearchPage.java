package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchText;
	
	@FindBy(xpath = "//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validSearchResultItem;
	
	@FindBy(xpath = "//div[@id='content']/h2/following-sibling::p")
	private WebElement noSearchResultMessage;
	
	public void enterSearchItem(String searchItem) {
		searchText.sendKeys(searchItem);
	}
	
	public void clickSearchbutton() {
		searchButton.click();
	}
	
	public boolean isSeachItemDisplayed() {
		return validSearchResultItem.isDisplayed();
	}
	
	public String getNoSearchResultMessage() {
		return noSearchResultMessage.getText();
	}
	
	
	public void searchProduct(String product) {
		searchText.sendKeys(product);
		searchButton.click();
	}
	
	
	
	
	

}
