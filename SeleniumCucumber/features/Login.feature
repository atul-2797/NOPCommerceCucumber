Feature: Login

  Scenario: successful login with valid credentials
    Given User launch chrome browser
    When  User opens url "https://admin-demo.nopcommerce.com/login"
    And   User enters email "admin@yourstore.com" and password "admin"
    And 	User clicks on login button
    Then 	Page title should be "Dashboard / nopCommerce administration"
    When 	User clicks on logout link
    Then 	Page title should be "Your store. Login"
    Then 	Close browser
    


