package com.qmetry.qaf.example.pages;

import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.example.steps.StepsLibrary;

public class CategoryPage extends StepsLibrary {
	private String xpath = "";
	
	 
	public String getDialogContent() {
		xpath = "//*[@id='layer_cart' and not(contains(@style,'display: none'))]";
    	QAFExtendedWebElement ele = new QAFExtendedWebElement(xpath);
        ele.waitForVisible();
        return ele.getAttribute("innerText");
    }

}
