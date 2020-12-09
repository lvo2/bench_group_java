package com.qmetry.qaf.example.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.example.steps.StepsLibrary;

public class HomePage extends StepsLibrary {
	private String xpath = "";
	
	@FindBy(locator = "homepage.button.signIn")
	QAFWebElement signIn;
	
	public void clickOnSignInButton() {
		clickOnElement(signIn);
	}
	
	public void navigateToSection(String section) throws Exception {
		try {
			xpath = "//*[@id='block_top_menu']/ul/li/*[normalize-space(text())='" + section + "']";
			QAFWebElement we = driver.findElement(By.xpath(xpath));
			if (waitUntilElementExisted(we)) {
				clickOnElement(we);
				QAFTestBase.pause(1000);
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
