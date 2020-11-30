package com.qmetry.qaf.example.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.example.steps.StepsLibrary;

public class Login extends StepsLibrary {
	
	@FindBy(locator = "login.input.emailAddress")
	QAFWebElement emailAddress;
	
	@FindBy(locator = "login.input.password")
	QAFWebElement password;
	
	@FindBy(locator = "login.button.signIn")
	QAFWebElement signIn;
	
	@FindBy(locator = "login.button.userName")
	QAFWebElement userName;
	
	@FindBy(locator = "login.button.signOut")
	QAFWebElement signOut;
	
	public void login() throws IOException {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("resources/application.properties");
		prop.load(input);
		QAFTestBase.pause(1000);
		emailAddress.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		clickOnElement(signIn);
	}
	
	public boolean userNameIsDisplayed() {
		return waitUntilElementExisted(userName)?true:false;
	}
	
	public void signOut() {
		clickOnElement(signOut);
	}

}
