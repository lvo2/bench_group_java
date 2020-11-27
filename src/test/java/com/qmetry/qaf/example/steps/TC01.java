package com.qmetry.qaf.example.steps;

import java.io.IOException;
import org.testng.Assert;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.example.pages.HomePage;
import com.qmetry.qaf.example.pages.Login;

public class TC01 extends StepsLibrary{
	
	HomePage homePage = new HomePage();
	Login loginPage = new Login();

	@QAFTestStep(description = "login into system")
	public void navigateToURL() throws IOException {
		setUpTest();
		homePage.clickOnSignInButton();
		loginPage.login();
	}
	
	@QAFTestStep(description = "verify that successfully login")
	public void verifyThatSuccessfullyLogin() throws IOException {
		if (!loginPage.userNameIsDisplayed())
			Assert.fail("Login failed");;
	}
	
}
