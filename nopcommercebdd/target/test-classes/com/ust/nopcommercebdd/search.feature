Feature: Search Functionality of nopcommerce

Scenario: Search with null value
		   Given the user in the search page
		   When user pass the null value
		   And the search button is clicked
		   Then the error msg should be displayed
		   
Scenario: Search the invalid item
		   Given the user in the search page
		   When user pass the invalid value
		   And the search button is clicked
		   Then the error message should be displayed
		   
Scenario: Search the valid item
		   Given the user in the search page
		   When user pass the valid value
		   And the search button is clicked
		   Then the results will be displayed		   
