package com.comcast.crm.generic.fileutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.Object_RepositoryTest.HomePage;
import com.comcast.crm.Object_RepositoryTest.LoginPage;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.webdriverutility.JaveUtility;

public class BaseClassTest {

	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JaveUtility jLib = new JaveUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite
	public void configBS() {
		System.out.println("==Connect to DB, Report config==");
		dbLib.getDbConnection();
	}

	@BeforeClass
	public void configBc() throws Throwable {
		System.out.println("==Launch the Browser==");
		String BROWSER = fLib.getDataFromPropertyFile("browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
	}

	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("==Login==");
		String URL = fLib.getDataFromPropertyFile("url");
		String USERNAME = fLib.getDataFromPropertyFile("username");
		String PASSWORD = fLib.getDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod
	public void configAM() {
		System.out.println("==LogOut==");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass
	public void configAC() {
		System.out.println("==Close the Browser==");
		driver.quit();
	}

	@AfterSuite
	public void configAS() {
		System.out.println("==Close DB, Report Backup==");
		dbLib.closeDbConnection();
	}

}
