@tag
Feature: Purchase order from Ecommerce Website
  I want to use this template for my feature file

  
  Background:
  Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test fo Submitting the order
    Given Logined in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConformatioPage

    Examples: 
      | name  							| password		 |	productName  |
      | dhanunjai@gmail.com | Dhanunjai@013| ZARA COAT 3 	 |
      
