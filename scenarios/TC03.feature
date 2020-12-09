@TC03
Feature: Shopping Card

@TC03.01
Scenario: [1]-Verify quantity of Shopping card
	Given 	direct to home page
	When 	I navigate to "Women" page
	And		I click on "Add to cart" button of the product as "Faded Short Sleeve T-shirts"
	Then	I verify a Pop-up appeared with text "There is 1 item in your cart."
	
@TC03.02
Scenario: [2]-Verify quantity of Shopping card with Quick view pop up
	Given 	direct to home page
	When 	I navigate to "Women" page
	And		I click on "Quick view" button of the product as "Faded Short Sleeve T-shirts"
	And		I click on Add to cart button on Quick View Pop-up
	When 	click on button with value 'Cart'
	
	