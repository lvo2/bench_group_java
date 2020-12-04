package com.qmetry.qaf.example.steps;

import java.util.HashMap;
import java.util.Properties;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.example.pages.HomePage;
import com.qmetry.qaf.example.pages.Login;
import com.qmetry.qaf.example.pages.Registration;

public class TC02 extends StepsLibrary {

	HomePage homePage = new HomePage();
	Login loginPage = new Login();
	Registration registrationPage = new Registration();
	Properties prop = new Properties();

	@QAFTestStep(description = "fill user data for creating user based on {data}")
	public void loginIntoSystem(Object data) throws Exception {
		HashMap<String, Object> resultInfo = null;
		resultInfo = jsonObjectToHashMap(data, "PersonalInformation");
		String title = tryToGetHashMapValue(resultInfo, "title");
		String firstName = tryToGetHashMapValue(resultInfo, "firstName");
		String lastName = tryToGetHashMapValue(resultInfo, "lastName");
		String email = tryToGetHashMapValue(resultInfo, "email");
		String password = tryToGetHashMapValue(resultInfo, "password");
		String dob = tryToGetHashMapValue(resultInfo, "dob");
		String newsletter = tryToGetHashMapValue(resultInfo, "newsletter");
		String receiveOffers = tryToGetHashMapValue(resultInfo, "receiveOffers");

		registrationPage.selectGender(title);
		registrationPage.setFirstName(firstName);
		registrationPage.setLastName(lastName);
	}
  
}
