
@tag
Feature: Error Validation
  I want to use this template for my feature file

  
  @errorvalidations
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Logined in with username <name> and password <password>
    Then "Incorrect email or password." is displayed

    Examples: 
      | name  							| password		 |
      | dhanunjai@gmail.com | Dhanunjai013	|