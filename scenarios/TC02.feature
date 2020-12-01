@TC02
Feature: Login Feature

@TC02.01 
Scenario:  Click Search button without entering any keyword 
	Given login into system
	Then verify that successfully login
	When I click on "Search" button
	Then I will be show Search page
	And I see message "Please enter a search keyword" in screen
	
	