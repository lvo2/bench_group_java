package com.qmetry.qaf.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.example.steps.StepsLibrary;

public class CategoryPage extends StepsLibrary {
	private String xpath = "";
	
	@FindBy(locator = "CategoryPage.dialog.addToCart")
	QAFWebElement dialogAddToCart;
	@FindBy(locator = "CategoryPage.btn.quickView.addToCart")
	QAFWebElement btnQuickViewAddToCart;
	@FindBy(locator = "CategoryPage.btn.addToCart.close")
	QAFWebElement btnAddToCartClose;
	 
	public String getDialogContent() {
    	dialogAddToCart.waitForVisible();
        return dialogAddToCart.getAttribute("innerText");
    }
	//* It is impossible to click iframe directly through XPath since it is an iframe. First we have to switch to the frame and then we can click using xpath.
	public void swithToQuickViewIFrame() {
		WebElement iframeElement = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframeElement);
		clickOnElement(btnQuickViewAddToCart); 
    }
	
	public void clickAddToCartOnQuickViewPopup() {
		swithToQuickViewIFrame();
		driver.switchTo().defaultContent();
		clickOnElement(btnAddToCartClose); 
    }
	
	public void moveToElement(String elementName) {
		xpath = String.format("//*[@class='product-container']//img[@title='%s']", elementName);
   	 	QAFExtendedWebElement eleProduct = new QAFExtendedWebElement(xpath);
   	 	new Actions(driver).moveToElement(eleProduct).perform();
    }
}
