@TC01
Feature: Login Feature

@TC01.01_Valid_username_and_password
Scenario: TC01.01
	Given login into system
	Then verify that successfully login
	And logout
    
@TC01.01_Invalid_username_and_password
Scenario: TC01.02
	Given direct to home page
	When click on button with value 'Sign in'
	And sendKeys '${username}' into 'login.input.emailAddress'
	And sendKeys '${password}' into 'login.input.password'
	And click on 'login.button.signIn'
	And verify 'login.text.errorMessage1' text is 'Authentication failed.'