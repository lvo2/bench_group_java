package com.qmetry.qaf.example.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.example.steps.StepsLibrary;

public class HomePage extends StepsLibrary {
	
	private static final int DEFAULT_TIMEOUT = 10;
	
	@FindBy(locator = "homepage.button.signIn")
	QAFWebElement signIn;
	
	public void clickOnSignInButton() {
		signIn.waitForVisible(DEFAULT_TIMEOUT*1000);
		clickOnElement(signIn);
	}

}
