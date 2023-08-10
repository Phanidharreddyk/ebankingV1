package com.ebanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.XPATH, using = "//input[@value='m']")
	@CacheLookup
	WebElement rdMale;
	
	@FindBy(how = How.XPATH, using = "//input[@value='f']")
	@CacheLookup
	WebElement rdFemale;

	@FindBy(how = How.XPATH, using = "//input[@id='dob']")
	@CacheLookup
	WebElement txtDOB;

	@FindBy(how = How.XPATH, using = "//textarea[@name='addr']")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(how = How.XPATH, using = "//input[@name='city']")
	@CacheLookup
	WebElement txtCity;

	@FindBy(how = How.XPATH, using = "//input[@name='state']")
	@CacheLookup
	WebElement txtState;

	@FindBy(how = How.XPATH, using = "//input[@name='pinno']")
	@CacheLookup
	WebElement txtPIN;

	@FindBy(how = How.XPATH, using = "//input[@name='telephoneno']")
	@CacheLookup
	WebElement txtMobileNumber;

	@FindBy(how = How.XPATH, using = "//input[@name='emailid']")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(how = How.XPATH, using = "//input[@name='sub']")
	@CacheLookup
	WebElement btnSubmit;

	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}

	public void custName(String name) {
		txtCustomerName.sendKeys(name);
	}

	public void custGender(Character gen) {
		if(gen=='m') rdMale.click();
		else rdFemale.click();
	}

	public void custDOB(String mm, String dd, String yy) {
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yy);
	}

	public void custAddress(String address) {
		txtAddress.sendKeys(address);
	}

	public void custCity(String city) {
		txtCity.sendKeys(city);
	}
	
	public void custState(String state) {
		txtState.sendKeys(state);
	}

	public void custPin(String pin) {
		txtPIN.sendKeys(String.valueOf(pin));
	}

	public void custMobileNumber(String i) {
		txtMobileNumber.sendKeys(i);
	}

	public void custEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void custPassword(String pass) {
		txtPassword.sendKeys(pass);
	}

	public void clickSubmit() {
		btnSubmit.click();
	}

}
