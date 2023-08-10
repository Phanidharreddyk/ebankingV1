package com.ebanking.testCases;

import org.testng.annotations.Test;

import com.ebanking.pageObjects.AddCustomerPage;
import com.ebanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(user);
		logger.info("providing username");
		
		lp.setPassword(pswd);
		logger.info("providing password");
		
		lp.clickSubmit();

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();
		logger.info("providing new customer details");

		addcust.custName("Phani");
		addcust.custGender('m');
		addcust.custDOB("11", "21", "2000");
		addcust.custAddress("India");
		addcust.custCity("Madanapalle");
		addcust.custState("Annamayya");

		String pin = randomNum(6);
		addcust.custPin(pin);

		String number = randomNum(10);
		addcust.custMobileNumber(number);

		String email = randomString() + "@gmail.com";
		addcust.custEmail(email);

		addcust.custPassword(randomString());
		addcust.clickSubmit();
		
		logger.info("Validation started...");
		Thread.sleep(3000);

		Assert.assertTrue(driver.getPageSource().contains("Customer Registered Successfully!!!"));
		
	}

}
