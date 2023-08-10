package com.ebanking.pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(name = "uid")
	WebElement txtUsername;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	WebElement btnLogin;
	
	@FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement btnLogout;

	public void setUserName(String uname) {
		txtUsername.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickSubmit() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
}
