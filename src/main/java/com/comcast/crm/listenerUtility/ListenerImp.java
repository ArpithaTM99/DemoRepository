package com.comcast.crm.listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.fileutility.BaseClassTest;

public class ListenerImp implements ITestListener, ISuiteListener {

	public ExtentReports report;
	ExtentTest test;

	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		// Spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);

		// add Env information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window 11");
		report.setSystemInfo("Browser", "Chrome");
	}

	public void onFinish(ISuite suite) {
		System.out.println("Report bachUp");
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("========" + result.getMethod().getMethodName() + "====Start====");
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName()+"====Started====");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("========" + result.getMethod().getMethodName() + "====END====");
		test.log(Status.PASS, result.getMethod().getMethodName()+"====Completed====");
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();

		TakesScreenshot eDriver = (TakesScreenshot) BaseClassTest.sdriver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"====Failed====");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
