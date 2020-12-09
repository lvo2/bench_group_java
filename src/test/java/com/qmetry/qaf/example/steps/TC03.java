package com.qmetry.qaf.example.steps;

import static org.testng.Assert.assertTrue;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.example.pages.CategoryPage;
import com.qmetry.qaf.example.pages.HomePage;

public class TC03 extends StepsLibrary {

	HomePage homePage = new HomePage();
	CategoryPage categoryPage = new CategoryPage();
		
	//* Button: Add to card, More, Quick view
    @QAFTestStep(description = "I click on {button} button of the product as {productName}")
    public void clickOnButton(String button, String productName ) throws Exception {
    	categoryPage.moveToElement(productName);
        String xpath = String.format("//ul[contains(@class,'product_list')]/li[contains(@class,'hovered')]//span[text()='%s']", button);
        QAFExtendedWebElement ele = new QAFExtendedWebElement(xpath);
        waitUntilElementExisted(ele);
        clickOnElement(ele);
    }
   
    @QAFTestStep(description = "I will be show the {0} page")
    public void iWillBeShowThePage(String page) throws Exception {
    	 String xpath = String.format("//*[contains(@class,'page-heading')]");
    	 QAFExtendedWebElement ele = new QAFExtendedWebElement(xpath);
    	 assertTrue(ele.getAttribute("innerText").contains(page.toUpperCase()));
    }
    
    @QAFTestStep(description = "I navigate to {0} page")
    public void iNavigateToPage(String page) throws Exception {
        homePage.navigateToSection(page);
        iWillBeShowThePage(page);
    }
    
    @QAFTestStep(description = "I verify a Pop-up appeared with text {text}")
    public void iVerifyAPopUpAppearWithText(String text) {
        assertTrue(categoryPage.getDialogContent().contains(text));
    }
    
    @QAFTestStep(description = "I click on Add to cart button on Quick View Pop-up")
    public void iClickOnAddToCartOnQuickViewPopUp() {
    	categoryPage.clickAddToCartOnQuickViewPopup();
    }
}
