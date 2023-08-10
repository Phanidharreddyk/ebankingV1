package com.ebanking.testCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;
import com.ebanking.pageObjects.LoginPage;
import com.ebanking.utilities.ReadXLS;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProviderClass = ReadXLS.class, dataProvider = "data")
	public void loginDDT(String username, String password) {
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("username provided");
		
		lp.setPassword(password);
		logger.info("password provided");
		
		lp.clickSubmit();
		
		
		if (isAlert()) {
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("Login failed");
			Assert.assertTrue(false);
			

			
			
		} else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();

		}

	}

	public boolean isAlert() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
