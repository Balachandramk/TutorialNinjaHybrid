package com.tutorialsninja.qa.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class Base {

	public WebDriver driver;
	public Properties configProp, testDataProp;
	

	public Base() {

		configProp = new Properties();
		testDataProp = new Properties();

		try {
			FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
			configProp.load(fis1);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
			testDataProp.load(fis2);
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {

		if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox") | browserName.equalsIgnoreCase("mozilla")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));

		driver.get(configProp.getProperty("url"));

		return driver;
	}
}
