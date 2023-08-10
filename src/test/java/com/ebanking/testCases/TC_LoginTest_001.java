package com.ebanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {

	
	@Test
	public void loginTest() {
		
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(user);
		logger.info("username entered");

		lp.setPassword(pswd);
		logger.info("password entered");

		lp.clickSubmit();
	
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			logger.info("Login Successfull");
			Assert.assertTrue(true);
		}
		else {
			logger.info("Login Failed");
			Assert.assertTrue(false);
		}
	}

}
