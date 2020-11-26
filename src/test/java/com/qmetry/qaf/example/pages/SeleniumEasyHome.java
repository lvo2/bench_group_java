package com.qmetry.qaf.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import org.openqa.selenium.support.PageFactory;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.example.steps.StepsLibrary;

public class SeleniumEasyHome extends StepsLibrary {
	
	@FindBy(locator = "input.search")
	WebElement searchBox;
	
	private WebDriver driver;
	
	public void sendTextToSearchBox(String text) {
		//searchBox.sendKeys(text);
		sendKeys(text, "input.search");
	}
	
	public SeleniumEasyHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
