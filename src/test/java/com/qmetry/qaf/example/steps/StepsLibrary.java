package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.ui.webdriver.ElementFactory.$;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class StepsLibrary extends WebDriverBaseTestPage<WebDriverTestPage> {

	private final int DEFAULT_TIMEOUT = 20;
	
	private String color = "";
	private int tmpColorIndex = -1;
	private ArrayList<Integer> numList = null;
	private String[] colorList = { "#ffe6e6, #f7e6fa", "#ccf2ff, #e3d6ff", "#dbfff5, #fffadd",
			"#fff7dd, #ffdbdb", "#f5d5ff, #dbe1ff", "#d9ffe6, #fff6e2, #ffe2e2" };
	
	@QAFTestStep(description = "click on button with value {value}")
	public void clickOnButtonWithValue(String value) throws IOException {
		String xpath = String.format("//*[normalize-space(text())='%s']", value);
		QAFWebElement we = driver.findElement(By.xpath(xpath));
		clickOnElement(we);
	}
	
	public static void performTextValidation(String actual, String expected) {
		Validator.verifyThat(actual, Matchers.equalTo(expected));
	}

	public boolean waitUntilElementExisted(QAFWebElement we) {
		try {
			we.waitForVisible(DEFAULT_TIMEOUT * 1000);
			return true;
		} catch (Exception e1) {
			return false;
		}
	}
	
	public void clickOnElement(QAFWebElement p_elem) {
		int i = 0;
		do {
			try {
				setColor(p_elem);
				p_elem.click();
				return;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Attempting to click the element: " + p_elem.getAttribute("class"));
				i += 1;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		} while (i < DEFAULT_TIMEOUT);
	}
	
	public static void clickOnElement(QAFExtendedWebElement ele) throws Exception {
		try {
			ele.click();
		} catch (Exception e) {
			ele.executeScript("click()");
		}
	}
	
	public void setColor(QAFWebElement we) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (tmpColorIndex == colorList.length - 1 || tmpColorIndex == -1) {
			numList = new ArrayList<>();
			for (int i = 0; i < colorList.length; i++) {
				numList.add(i);
			}
			Collections.shuffle(numList);
			tmpColorIndex = 0;
			color = colorList[numList.get(tmpColorIndex)];
		} else {
			tmpColorIndex++;
			color = colorList[numList.get(tmpColorIndex)];
		}

		js.executeScript(String.format(
				"arguments[0].setAttribute('style', 'background:linear-gradient(to right, %s) !important;color:#E74856 !important')",
				color), we);
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub

	}
}
