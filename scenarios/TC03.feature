@TC03
Feature: Shopping Card

@TC03.01
Scenario: [1]-Verify quantity of Shopping card
	Given 	direct to home page
	When 	I navigate to "Women" page
	And		I select product as "Faded Short Sleeve T-shirts" to add to the cart
	Then	I verify a dialog appeared with text "There is 1 item in your cart."