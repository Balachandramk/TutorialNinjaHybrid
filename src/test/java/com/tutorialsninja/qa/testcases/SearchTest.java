package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends Base {

	public SearchTest() {
		super();
	}

	public WebDriver driver;
	SearchPage searchPage;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplicationURL(configProp.getProperty("browser"));
		searchPage = new SearchPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifySearchWithValidProduct() {

		// searchPage.enterSearchItem(testDataProp.getProperty("validSearchProduct"));
		// driver.findElement(By.xpath("//input[@name='search']")).sendKeys(testDataProp.getProperty("validSearchProduct"));
		// searchPage.clickSearchbutton();
		// driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		searchPage.searchProduct(testDataProp.getProperty("validSearchProduct"));
		Assert.assertTrue(searchPage.isSeachItemDisplayed(), "No Search results found");

	}

	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {

		// searchPage.enterSearchItem(testDataProp.getProperty("invalidSearchProduct"));
		// driver.findElement(By.xpath("//input[@name='search']")).sendKeys(testDataProp.getProperty("invalidSearchProduct"));
		// searchPage.clickSearchbutton();
		// driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		searchPage.searchProduct(testDataProp.getProperty("invalidSearchProduct"));
		String actualSearchMessage = searchPage.getNoSearchResultMessage();
		String expectedNoMatchSearchMessage = testDataProp.getProperty("expectedNoMatchSearchMessage");
		// Assert.assertTrue(expectedNoMatchSearchMessage.equalsIgnoreCase(actualSearchMessage),
		// "Search results found for invalid search");

		Assert.assertTrue("AASSXX".equalsIgnoreCase(actualSearchMessage), "Search results found for invalid search");

	}

	@Test(priority = 3, dependsOnMethods = { "verifySearchWithInvalidProduct" })
	public void verifySearchWithoutEmptyDetails() {

		searchPage.clickSearchbutton();
		// driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		String actualSearchMessage = searchPage.getNoSearchResultMessage();
		String expectedNoMatchSearchMessage = testDataProp.getProperty("expectedNoMatchSearchMessage");
		Assert.assertTrue(expectedNoMatchSearchMessage.equalsIgnoreCase(actualSearchMessage),
				"Search results found for invalid search");

	}
}
