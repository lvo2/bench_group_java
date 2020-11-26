package com.qmetry.qaf.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import org.openqa.selenium.support.PageFactory;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.example.steps.StepsLibrary;

public class GoogleHome extends StepsLibrary {
	
	@FindBy(locator = "input.search")
	QAFWebElement searchBox;
	
	public void sendTextToSearchBox(String text) {
		searchBox.sendKeys(text);
		//QAFWebDriver driver = new WebDriverTestBase().getDriver();
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
