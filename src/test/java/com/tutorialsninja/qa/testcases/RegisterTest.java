package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.LandingHomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {

	public RegisterTest() {
		super();
	}

	public WebDriver driver;
	LandingHomePage landingHomePage;
	RegisterPage registerPage;

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(configProp.getProperty("browser"));
		landingHomePage = new LandingHomePage(driver);
		registerPage = new RegisterPage(driver);

		landingHomePage.clickOnMyAccount();
		// driver.findElement(By.xpath("//span[text()='My Account']")).click();
		landingHomePage.clickOnRegister();
		// driver.findElement(By.xpath("//a[text()='Register']")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyRegisteringWithMandatoryFields() throws InterruptedException {

		//registerPage.enterFirstName(testDataProp.getProperty("firstName"));
		// driver.findElement(By.id("input-firstname")).clear();
		// driver.findElement(By.id("input-firstname")).sendKeys(testDataProp.getProperty("firstName"));
		//registerPage.enterLastName(testDataProp.getProperty("lastName"));
		// driver.findElement(By.id("input-lastname")).clear();
		// driver.findElement(By.id("input-lastname")).sendKeys(testDataProp.getProperty("lastName"));
		//registerPage.enterEmail(Utilities.generateEmailWithTimeStamp());
		// driver.findElement(By.id("input-email")).clear();
		// driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		//registerPage.enterTelephone(testDataProp.getProperty("telephoneNumber"));
		// driver.findElement(By.id("input-telephone")).clear();
		// driver.findElement(By.id("input-telephone")).sendKeys(testDataProp.getProperty("telephoneNumber"));
		//registerPage.enterPassword(configProp.getProperty("validPassword"));
		// driver.findElement(By.id("input-password")).clear();
		// driver.findElement(By.id("input-password")).sendKeys(configProp.getProperty("validPassword"));
		//registerPage.enterConfirmPassword(configProp.getProperty("validPassword"));
		// driver.findElement(By.id("input-confirm")).clear();
		// driver.findElement(By.id("input-confirm")).sendKeys(configProp.getProperty("validPassword"));
		//registerPage.checkPrivacyPolicy();
		// driver.findElement(By.xpath("//input[@name='agree']")).click();
		registerPage.enterMandatoryFields(testDataProp.getProperty("firstName"), testDataProp.getProperty("lastName"),
				Utilities.generateEmailWithTimeStamp(), testDataProp.getProperty("telephoneNumber"),
				configProp.getProperty("validPassword"), configProp.getProperty("validPassword"));
		registerPage.clickContinue();
		Thread.sleep(2000);
		String actualSuccessMessage = registerPage.getAccountCreatedSuccessMessage();
		String expectedSuccessMessage = testDataProp.getProperty("expectedSuccessMessage");

		Assert.assertTrue(expectedSuccessMessage.equalsIgnoreCase(actualSuccessMessage),
				"Account created message not displayed");

	}

	@Test(priority = 2)
	public void verifyRegisteringWithAllFields() throws InterruptedException {

		//registerPage.enterFirstName(testDataProp.getProperty("firstName"));
		// driver.findElement(By.id("input-firstname")).clear();
		// driver.findElement(By.id("input-firstname")).sendKeys(testDataProp.getProperty("firstName"));
		//registerPage.enterLastName(testDataProp.getProperty("lastName"));
		// driver.findElement(By.id("input-lastname")).clear();
		// driver.findElement(By.id("input-lastname")).sendKeys(testDataProp.getProperty("lastName"));
		//registerPage.enterEmail(Utilities.generateEmailWithTimeStamp());
		// driver.findElement(By.id("input-email")).clear();
		// driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		//registerPage.enterTelephone(testDataProp.getProperty("telephoneNumber"));
		// driver.findElement(By.id("input-telephone")).clear();
		// driver.findElement(By.id("input-telephone")).sendKeys(testDataProp.getProperty("telephoneNumber"));
		//registerPage.enterPassword(configProp.getProperty("validPassword"));
		// driver.findElement(By.id("input-password")).clear();
		// driver.findElement(By.id("input-password")).sendKeys(configProp.getProperty("validPassword"));
		//registerPage.enterConfirmPassword(configProp.getProperty("validPassword"));
		// driver.findElement(By.id("input-confirm")).clear();
		// driver.findElement(By.id("input-confirm")).sendKeys(configProp.getProperty("validPassword"));
		//registerPage.selectNewsLetterYesRadio();
		// driver.findElement(By.xpath("//input[@name='newsletter'][@value=1]")).click();
		//registerPage.checkPrivacyPolicy();
		// driver.findElement(By.xpath("//input[@name='agree']")).click();
		
		// driver.findElement(By.xpath("//input[@value='Continue']")).click();;
		
		registerPage.enterAllFields(testDataProp.getProperty("firstName"), testDataProp.getProperty("lastName"),
				Utilities.generateEmailWithTimeStamp(), testDataProp.getProperty("telephoneNumber"),
				configProp.getProperty("validPassword"), configProp.getProperty("validPassword"));
		registerPage.clickContinue();
		Thread.sleep(2000);
		String actualSuccessMessage = registerPage.getAccountCreatedSuccessMessage();
		String expectedSuccessMessage = testDataProp.getProperty("expectedSuccessMessage");

		Assert.assertTrue(expectedSuccessMessage.equalsIgnoreCase(actualSuccessMessage),
				"Account created message not displayed");

	}

	@Test(priority = 3)
	public void verifyRegisteringWithExistingEmail() throws InterruptedException {

		//registerPage.enterFirstName(testDataProp.getProperty("firstName"));
		// driver.findElement(By.id("input-firstname")).clear();
		// driver.findElement(By.id("input-firstname")).sendKeys(testDataProp.getProperty("firstName"));
		//registerPage.enterLastName(testDataProp.getProperty("lastName"));
		// driver.findElement(By.id("input-lastname")).clear();
		// driver.findElement(By.id("input-lastname")).sendKeys(testDataProp.getProperty("lastName"));
		//registerPage.enterEmail(configProp.getProperty("validEmail"));
		// driver.findElement(By.id("input-email")).clear();
		// driver.findElement(By.id("input-email")).sendKeys(configProp.getProperty("validEmail"));
		//registerPage.enterTelephone(testDataProp.getProperty("telephoneNumber"));
		// driver.findElement(By.id("input-telephone")).clear();
		// driver.findElement(By.id("input-telephone")).sendKeys(testDataProp.getProperty("telephoneNumber"));
		//registerPage.enterPassword(configProp.getProperty("validPassword"));
		// driver.findElement(By.id("input-password")).clear();
		// driver.findElement(By.id("input-password")).sendKeys(configProp.getProperty("validPassword"));
		//registerPage.enterConfirmPassword(configProp.getProperty("validPassword"));
		// driver.findElement(By.id("input-confirm")).clear();
		// driver.findElement(By.id("input-confirm")).sendKeys(configProp.getProperty("validPassword"));
		//registerPage.selectNewsLetterYesRadio();
		// driver.findElement(By.xpath("//input[@name='newsletter'][@value=1]")).click();
		//registerPage.checkPrivacyPolicy();
		// driver.findElement(By.xpath("//input[@name='agree']")).click();
		
		// driver.findElement(By.xpath("//input[@value='Continue']")).click();;
		registerPage.enterAllFields(testDataProp.getProperty("firstName"), testDataProp.getProperty("lastName"),
				configProp.getProperty("validEmail"), testDataProp.getProperty("telephoneNumber"),
				configProp.getProperty("validPassword"), configProp.getProperty("validPassword"));
		registerPage.clickContinue();
		Thread.sleep(2000);
		
		String actualWarningEmailMessage = registerPage.getAlreadyEmailExistWarningMessage();
		String expectedWarningEmailMessage = testDataProp.getProperty("expectedWarningEmailMessage");

		Assert.assertTrue(expectedWarningEmailMessage.equalsIgnoreCase(actualWarningEmailMessage),
				"Expected Warning message not dispplayed");

	}

	@Test(priority = 4)
	public void verifyRegisteringWithoutAnyDetails() throws InterruptedException {

		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Thread.sleep(2000);

		String actualPolicyWarningMessage = registerPage.getPrivacyPolicyWarningMessage();
		String expectedPolicyWarningMessage = testDataProp.getProperty("expectedPolicyWarningMessage");
		Assert.assertTrue(expectedPolicyWarningMessage.equalsIgnoreCase(actualPolicyWarningMessage),
				"Expected Privacy Policy warning message not dispplayed");

		String actualFirstnameErrorMessage = registerPage.getFirstNameWarningMessage();
		String expectedFirstnameErrorMessage = testDataProp.getProperty("expectedFirstnameErrorMessage");
		Assert.assertTrue(expectedFirstnameErrorMessage.equalsIgnoreCase(actualFirstnameErrorMessage),
				"Expected Firstname error message not dispplayed");

		String actualLastnameErrorMessage = registerPage.getLastNameWarningMessage();
		String expectedLastnameErrorMessage = testDataProp.getProperty("expectedLastnameErrorMessage");
		Assert.assertTrue(expectedLastnameErrorMessage.equalsIgnoreCase(actualLastnameErrorMessage),
				"Expected Lastname error message not dispplayed");

		String actualEmailErrorMessage = registerPage.getEmailWarningMessage();
		String expectedEmailErrorMessage = testDataProp.getProperty("expectedEmailErrorMessage");
		Assert.assertTrue(expectedEmailErrorMessage.equalsIgnoreCase(actualEmailErrorMessage),
				"Expected Email error message not dispplayed");

		String actualPhoneErrorMessage = registerPage.getTelephoneWarningMessage();
		String expectedPhoneErrorMessage = testDataProp.getProperty("expectedPhoneErrorMessage");
		Assert.assertTrue(expectedPhoneErrorMessage.equalsIgnoreCase(actualPhoneErrorMessage),
				"Expected Phone error message not dispplayed");

		String actualPasswordErrorMessage = registerPage.getPasswordWarningMessage();
		String expectedPasswordErrorMessage = testDataProp.getProperty("expectedPasswordErrorMessage");
		Assert.assertTrue(expectedPasswordErrorMessage.equalsIgnoreCase(actualPasswordErrorMessage),
				"Expected Password error message not dispplayed");

	}
}
