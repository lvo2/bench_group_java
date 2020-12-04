package com.qmetry.qaf.example.pages;

import java.io.IOException;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.example.steps.StepsLibrary;

public class Registration extends StepsLibrary {
	
	@FindBy(locator = "registration.radio.title.mr")
	QAFWebElement genderMr;
	
	@FindBy(locator = "registration.radio.title.mrs")
	QAFWebElement genderMrs;
	
	@FindBy(locator = "registration.input.firstName")
	QAFWebElement firstName;
	
	@FindBy(locator = "registration.input.lastName")
	QAFWebElement lastName;
	
	public void selectGender(String gender) throws IOException {
		if (gender.equalsIgnoreCase("Mr."))
			clickOnElement(genderMr);
		else
			clickOnElement(genderMrs);
	}
	
	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}

}
