Feature: Login Functionality in nopecommerce

Scenario: login with valid credentials
		Given the user in the nopecommerce login page
		When the user name and password entered
		And the login button is clicked
		Then the user should be logged in successfully
		
Scenario: login with invalid credentials
		Given the user in the nopecommerce login page
		When the invalid user name and password entered
		And the login button is clicked
		Then error message should be displayed
		
		
Scenario: login with null values
		Given the user in the nopecommerce login page
		When the login button is clicked 
		Then  appropriate  error message should be displayed


		  