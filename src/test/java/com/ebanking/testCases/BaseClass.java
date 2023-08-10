package com.ebanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import com.ebanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String user = readconfig.getUsername();
	public String pswd = readconfig.getPassword();
	public String baseURL = readconfig.getURL();
	
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) throws IOException {

		logger = LogManager.getLogger(BaseClass.class.getName());

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(baseURL);

		logger.info("URL is opened");

	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public String randomString() {
		return RandomStringUtils.randomAlphabetic(8);

	}
	public String randomNum(int num) {
		return RandomStringUtils.randomNumeric(num);
	}
	
	
}
