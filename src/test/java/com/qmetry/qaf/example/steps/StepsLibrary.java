package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.qmetry.qaf.automation.core.DriverFactory;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.example.pages.GoogleHome;

public class StepsLibrary extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	private WebDriver driver;
		
	@QAFTestStep(description = "navigate to {url}")
	public void navigateToURL(String url) throws IOException {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("resources/application.properties");
		prop.load(input);
		if (prop.getProperty("browser").toString().equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		if (prop.getProperty("browser").toString().equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get(prop.getProperty("env.baseurl"));
	}
	
	@QAFTestStep(description = "search for {0}")
	public void searchFor(String searchTerm) {
		sendKeys(searchTerm+Keys.ENTER, "input.search");
		GoogleHome ggHomePage = new GoogleHome();
		ggHomePage.sendTextToSearchBox("123");
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
}
