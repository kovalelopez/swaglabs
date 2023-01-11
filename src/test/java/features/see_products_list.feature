Feature: Products list
  Background: accessed swag labs site
    Given I accessed the swag labs site

    Scenario Outline: List validation
      When I make login with username <username> and password <password>
      Then I see product list
      Examples:
      |username         |password      |
      |"standard_user"  |"secret_sauce"|

    Scenario: count products list
      When I make login with username "standard_user" and password "secret_sauce"
      Then Validate the quantity of products

    Scenario: Validate price product
      Given I am logged in swag labs with username "standard_user" and password "secret_sauce"
      When Select the product "Sauce Labs Backpack"
      And I get the price
      Then Validate the price is correct "29.99"