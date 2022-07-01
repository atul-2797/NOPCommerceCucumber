Feature: Add new customer

Background: Below are the common steps for each scenario
		Given User launch chrome browser
    When  User opens url "https://admin-demo.nopcommerce.com/login"
    And   User enters email "admin@yourstore.com" and password "admin"
    And 	User clicks on login button
    Then 	Page title should be "Dashboard / nopCommerce administration"
    When 	User clicks on Customers Menu
    And 	User clicks on First Customers option                                 
    Then  Customers Dashboard should be displayed  

@Sanity
Scenario: add new customer successfully with given details      
    When  User clicks on Add New button
    Then  Add a New Customer page should be displayed
    When  User should enter customer information
    And   User clicks on Save button
    Then  Successful message "The new customer has been added successfully." should be displayed
    Then 	Close browser
       
@Regression 
Scenario: Search a customer by EmailID
    When  User enters customer email
    And   Click on search button
    Then  User should found email in the table
    Then 	Close browser