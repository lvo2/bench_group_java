package com.qmetry.qaf.example.steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.example.pages.HomePage;
import com.qmetry.qaf.example.pages.Login;

public class TC01 extends StepsLibrary{
	
	HomePage homePage = new HomePage();
	Login loginPage = new Login();
	Properties prop = new Properties();

	@QAFTestStep(description = "login into system")
	public void loginIntoSystem() throws IOException {
		directToHomePage();
		homePage.clickOnSignInButton();
		loginPage.login();
	}
	
	@QAFTestStep(description = "verify that successfully login")
	public void verifyThatSuccessfullyLogin() throws IOException {
		if (!loginPage.userNameIsDisplayed())
			Assert.fail("Login failed");;
	}
	
	@QAFTestStep(description = "direct to home page")
	public void directToHomePage() throws IOException {
		InputStream input = new FileInputStream("resources/application.properties");
		prop.load(input);
		CommonStep.get(prop.getProperty("env.baseurl"));
		driver.manage().window().maximize();
	}
	
	@QAFTestStep(description = "logout")
	public void logout() throws IOException {
		loginPage.signOut();
	}
}
