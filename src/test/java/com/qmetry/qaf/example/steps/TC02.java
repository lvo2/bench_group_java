package com.qmetry.qaf.example.steps;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.example.pages.HomePage;

public class TC02 extends StepsLibrary{
	@FindBy(locator = "SearchPage.page")
	QAFWebElement searchPage;
	
	HomePage homePage = new HomePage();
	Properties prop = new Properties();

	@QAFTestStep(description = "I click on {0} button")
	public void clickOnButton(String button) throws Exception {
		String xpath = String.format("//*[contains(text(),'%s')]", button);
		QAFExtendedWebElement ele = new QAFExtendedWebElement(xpath);
		ele.waitForPresent(3000);
		clickOnElement(ele);
	}
	
	@QAFTestStep(description = "I will be show Search page")
	public void iWillBeShownSearchPage() throws Exception {
		if (!searchPage.isPresent()) {
			Assert.fail("Search page is NOT displayed.");
		}
	}
	
	@QAFTestStep(description = "I see message {0} in screen")
	public void iSeeMessageInScreen(String message) throws IOException {
		String xpath = String.format("//*[contains(text(),'%s')]", message);
		QAFExtendedWebElement ele = new QAFExtendedWebElement(xpath);
		assertTrue(ele.isPresent());
	}
}
