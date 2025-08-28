package Tests;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.beust.jcommander.Parameter;
import com.google.gson.JsonObject;

import BasePackage.BaseClass;
import BasePackage.ExtentManager;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.ExcelUtils;

public class BookApplication extends BaseClass{
	LoginPage lp;
	HomePage hp;
	ExtentReports extent;
	ExtentTest test;
	Logger logger = LogManager.getLogger(BookApplication.class);
	@BeforeTest
	@Parameters("browser")
	public void LaunchBrowser(String str) throws InterruptedException, IOException {
		OpenBrowser(str);
		extent = ExtentManager.getReport();
	}
	
	@BeforeClass
	public void SetUpPages() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
	}
	
	@AfterTest
	public void QuitBrowser() {
		CloseBrowser();
		extent.flush();
	}
	
	@DataProvider(name = "dp")
	public Object[][] data() {
		return new Object[][] {{"TestUserJava","Test@123"},{"TestingUser","Test@123"}};
	}
	
	@Test(groups = "regression", dataProvider = "dp")
	public void LoginTest(String user, String pwd) throws IOException, ParserConfigurationException, SAXException {
		test = extent.createTest("Test case1");
		test.log(Status.INFO, "test case started");
		lp.EnterUsername(user);
		lp.EnterPassword(pwd);
		lp.ClickLogin();
		test.log(Status.INFO,"successful login");
		
	}
	
	@AfterMethod
	public void LogoutTest() {
		hp.ClickLogout();
	}
	
	
}


	

