package com.ebanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting extends TestListenerAdapter {

	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext testContext) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String repName = "Test-Report-" + timeStamp + ".html";

		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReports/" + repName);

		final File CONF = new File(
				System.getProperty("user.dir") + "/src/test/resources/Configuration/spark-config.xml");

		try {
			spark.loadXMLConfig(CONF);
		} catch (IOException e) {

			e.printStackTrace();
		}

		extent = new ExtentReports();
		extent.attachReporter(spark);

		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows11");
		extent.setSystemInfo("Tester Name", "Phani");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public void onTestSuccess(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String time = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String screenshotPath = System.getProperty("user.dir") + "/src/test/resources/Screenshots/" + tr.getName()
				+ time +".png";
		new Screenshot().getScreenshot(screenshotPath);

		File f = new File(screenshotPath);

		if (f.exists()) {

			//logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			 test.addScreenCaptureFromPath(screenshotPath);
		}
	}

	public void onTestSkipped(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));

	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}
