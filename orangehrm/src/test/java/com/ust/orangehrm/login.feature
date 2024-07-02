Feature: Orange HRM Login Functionality
@RegressionTest 
Scenario: login with valid credentials
		Given the user in the orange HRM login page
		When the user name and password entered
		And the login button is clicked
		Then the user should be logged in successfully
@SmokeTest 
Scenario: login with invalid credentials
		Given the user in the orange HRM login page
		When the invalid user name and password entered
		And the login button is clicked
		Then error message should be displayed
		  