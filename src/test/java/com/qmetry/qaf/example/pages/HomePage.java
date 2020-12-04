package com.qmetry.qaf.example.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.example.steps.StepsLibrary;

public class HomePage extends StepsLibrary {
	
	@FindBy(locator = "homepage.button.signIn")
	QAFWebElement signIn;
	
	public void clickOnSignInButton() {
		clickOnElement(signIn);
	}

}
