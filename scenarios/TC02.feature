@TC02
Feature: Registration Feature

@TC02.01_Registration_with_valid_fields
Scenario Outline: TC02.01
	Given direct to home page
	When click on button with value 'Sign in'
	And sendKeys '${username}' into 'login.input.createEmailAddress'
	And click on 'login.button.createAnAccount'
	And fill user data for creating user based on '<UserInfo>'
    
    Examples: {'datafile':'resources/data/TC02.json'}