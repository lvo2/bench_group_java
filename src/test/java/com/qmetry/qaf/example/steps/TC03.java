package com.qmetry.qaf.example.steps;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.example.pages.CategoryPage;
import com.qmetry.qaf.example.pages.HomePage;
import com.qmetry.qaf.example.pages.Login;

public class TC03 extends StepsLibrary {

	HomePage homePage = new HomePage();
	Login loginPage = new Login();
	Properties prop = new Properties();
	CategoryPage categoryPage = new CategoryPage();

    @QAFTestStep(description = "I will be show the {0} page")
    public void iWillBeShowThePage(String page) throws Exception {
    	 String xpath = String.format("//*[@class='navigation_page' and contains(text(), '%s')]", page);
    	 QAFExtendedWebElement ele = new QAFExtendedWebElement(xpath);
    	 if(!ele.isPresent()) {
    		Assert.fail("Page is not display");
    	 }
    }
    
    @QAFTestStep(description = "I navigate to {0} page")
    public void iNavigateToPage(String page) throws Exception {
        homePage.navigateToSection(page);
        iWillBeShowThePage(page);
    }
    
    @QAFTestStep(description = "I select product as {productName} to add to the cart")
    public void iSelectProductAsToAddToTheCart(String productName) throws Exception {
    	String xpath = String.format("//*[@class='product-container']//img[@title='%s']", productName);
   	 	QAFExtendedWebElement eleProduct = new QAFExtendedWebElement(xpath);
   	 	new Actions(driver).moveToElement(eleProduct).perform();
   	 	QAFExtendedWebElement eleButtonAdd = driver.findElement(By.xpath(xpath + "/ancestor::*[@class='product-container']//span[text()='Add to cart']"));
   	 	clickOnElement(eleButtonAdd);
    }
    
    @QAFTestStep(description = "I verify a dialog appeared with text {text}")
    public void iVerifyADialogAppearWithText(String text) {
        assertTrue(categoryPage.getDialogContent().contains(text));
    }
}
