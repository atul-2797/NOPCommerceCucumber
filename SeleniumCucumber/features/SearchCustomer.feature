Feature: Search customer 

Scenario: Search a customer by EmailID
		Given User launch chrome browser
    When  User opens url "https://admin-demo.nopcommerce.com/login"
    And   User enters email "admin@yourstore.com" and password "admin"
    And 	User clicks on login button
    Then 	Page title should be "Dashboard / nopCommerce administration"
    When 	User clicks on Customers Menu
    And 	User clicks on First Customers option
    Then  Customers Dashboard should be displayed
    When  User enters customer email
    And   Click on search button
    Then  User should found email in the table
    Then 	Close browser
         
    
    
    