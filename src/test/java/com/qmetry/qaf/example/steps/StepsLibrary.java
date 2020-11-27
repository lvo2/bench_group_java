package com.qmetry.qaf.example.steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class StepsLibrary extends WebDriverBaseTestPage<WebDriverTestPage> {

	private static final int DEFAULT_TIMEOUT = 20;
	
	@QAFTestStep(description = "set up test")
	public void setUpTest() throws IOException {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("resources/application.properties");
		prop.load(input);
		CommonStep.get(prop.getProperty("env.baseurl"));
		driver.manage().window().maximize();
	}
	
	@QAFTestStep(description = "click on button with value {value}")
	public void clickOnButtonWithValue(String value) throws IOException {
		String xpath = String.format("//*[normalize-space(text())='%s']", value);
		QAFWebElement we = driver.findElement(By.xpath(xpath));
		we.click();
	}
	
	public static void performTextValidation(String actual, String expected) {
		Validator.verifyThat(actual, Matchers.equalTo(expected));
	}

	public static boolean waitUntilElementExisted(QAFWebElement we) {
		try {
			we.waitForVisible(DEFAULT_TIMEOUT * 1000);
			return true;
		} catch (Exception e1) {
			return false;
		}
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}
}
