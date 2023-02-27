package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.LandingHomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.pages.MyAccountPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {

	public LoginTest() {
		super();
	}

	public WebDriver driver;
	LandingHomePage landingHomePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(configProp.getProperty("browser"));
		landingHomePage = new LandingHomePage(driver);
		loginPage = new LoginPage(driver);
		myAccountPage = new MyAccountPage(driver);
		
		landingHomePage.clickOnMyAccount();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		landingHomePage.clickOnLogin();
		//driver.findElement(By.xpath("//a[text()='Login']")).click();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1,dataProvider = "TestDataForValidLoginTest")
	public void verifyLoginWithValidCredentials(String email, String password) throws InterruptedException {
		
		//loginPage.enterUserEmail(email);
		//driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		//loginPage.enterUserPassword(password);
		//driver.findElement(By.xpath("//input[@id='input-password']")).clear();
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
		//loginPage.submitLogin();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();

		loginPage.login(email, password);
		
		Thread.sleep(2000);

		Assert.assertTrue(myAccountPage.displayStatusOfEditYourAccountInformationLink(),"Edit your account information is not displayed");

	}
	
	@DataProvider(name = "TestDataForValidLoginTest")
	public Object[][] supplyTestData(){
		
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		
		return data;
		
	}

	@Test(priority = 2)
	public void verifyLoginWithInValidCredentials() throws InterruptedException {

		//loginPage.enterUserEmail(Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		
		//loginPage.enterUserPassword(testDataProp.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//input[@id='input-password']")).clear();
		//driver.findElement(By.xpath("//input[@id='input-password']"))
		//		.sendKeys(testDataProp.getProperty("invalidPassword"));
		//loginPage.submitLogin();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		loginPage.login(Utilities.generateEmailWithTimeStamp(), testDataProp.getProperty("invalidPassword"));

		Thread.sleep(2000);

		String actualWarningMessage = loginPage.getMessageOfWarning();
		// System.out.println(actualMessage);
		String expectedWarningMassage = testDataProp.getProperty("expectedWarningMassage");
		Assert.assertTrue(expectedWarningMassage.equals(actualWarningMessage), "Warning message not displayed");

	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailAndValidPassword() throws InterruptedException {

		//loginPage.enterUserEmail(Utilities.generateEmailWithTimeStamp());
		//driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithTimeStamp());
		//loginPage.enterUserPassword(configProp.getProperty("validPassword"));
		//driver.findElement(By.xpath("//input[@id='input-password']")).clear();
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(configProp.getProperty("validPassword"));
		//loginPage.submitLogin();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();

		loginPage.login(Utilities.generateEmailWithTimeStamp(), configProp.getProperty("validPassword"));
		Thread.sleep(2000);

		String actualWarningMessage = loginPage.getMessageOfWarning();
		// System.out.println(actualMessage);
		String expectedWarningMassage = testDataProp.getProperty("expectedWarningMassage");
		Assert.assertTrue(expectedWarningMassage.equals(actualWarningMessage), "Warning message not displayed");

	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailAndInvalidPassword() throws InterruptedException {

		//loginPage.enterUserEmail(configProp.getProperty("validEmail"));
		//driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(configProp.getProperty("validEmail"));
		//loginPage.enterUserPassword(testDataProp.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//input[@id='input-password']")).clear();
		//driver.findElement(By.xpath("//input[@id='input-password']"))
		//		.sendKeys(testDataProp.getProperty("invalidPassword"));
		//loginPage.submitLogin();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();

		loginPage.login(configProp.getProperty("validEmail"), testDataProp.getProperty("invalidPassword"));
		Thread.sleep(2000);

		String actualWarningMessage = loginPage.getMessageOfWarning();
		// System.out.println(actualMessage);
		String expectedWarningMassage = testDataProp.getProperty("expectedWarningMassage");
		Assert.assertTrue(expectedWarningMassage.equals(actualWarningMessage), "Warning message not displayed");

	}

	@Test(priority = 5)
	public void verifyLoginWithEmptyCredentials() throws InterruptedException {

		loginPage.submitLogin();
		//driver.findElement(By.xpath("//input[@value='Login']")).click();

		Thread.sleep(2000);

		String actualWarningMessage = loginPage.getMessageOfWarning();
		// System.out.println(actualMessage);
		String expectedWarningMassage = testDataProp.getProperty("expectedWarningMassage");
		Assert.assertTrue(expectedWarningMassage.equals(actualWarningMessage), "Warning message not displayed");

	}

}
