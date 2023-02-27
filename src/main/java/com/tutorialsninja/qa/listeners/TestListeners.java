package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.ExtentReporter;
import com.tutorialsninja.qa.utils.Utilities;

public class TestListeners implements ITestListener {

	public ExtentReports extentReport;
	ExtentTest extentTest;

	public void onStart(ITestContext context) {
		// System.out.println("Tests in Tutorials Ninja Project started");
		extentReport = ExtentReporter.generateExtentReport();
	}

	public void onTestStart(ITestResult result) {
		// System.out.println(testName + " started executing");
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName() + " started executing");
	}

	public void onTestSuccess(ITestResult result) {
		// String testName = result.getName();
		// System.out.println(testName + " executed successfully");
		extentTest.log(Status.PASS, result.getName() + " executed successfully");
	}

	public void onTestFailure(ITestResult result) {
		// String testName = result.getName();

		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		extentTest.addScreenCaptureFromPath(Utilities.captureScreenshot(driver, result.getName()));
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName() + " failed");

		// System.out.println("Take Screenshot");
		// System.out.println(result.getThrowable());
		// System.out.println(result.getName() + " failed");
	}

	public void onTestSkipped(ITestResult result) {
		// String testName = result.getName();
		// System.out.println(testName + " skipped");
		// System.out.println(result.getThrowable());

		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName() + " skipped");
	}

	public void onFinish(ITestContext context) {
		// System.out.println("Tests in Tutorials Ninja Project finished");
		extentReport.flush();

		// Auto Open Extent Report
		try {
			Desktop.getDesktop().browse(
					new File((System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html"))
							.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
