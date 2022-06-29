Feature: LoginWithDD

  Scenario Outline: Data Driven Testing
  	Given User launch chrome browser
    When  User opens url "https://admin-demo.nopcommerce.com/login"
    And   User enters email "<email>" and password "<password>"
    And 	User clicks on login button
    Then 	Page title should be "Dashboard / nopCommerce administration"
    When 	User clicks on logout link
    Then 	Page title should be "Your store. Login"
    Then 	Close browser
    
    Examples:
    | email | password |
    | admin@yourstore.com | admin |
    | admin@yourstore.com | admin123 |