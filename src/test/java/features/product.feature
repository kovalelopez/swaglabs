Feature: Product tests
  Background:
    Given I am logged in swag labs with username "standard_user" and password "secret_sauce"
  Scenario Outline: add product in the by description page
    When I access the product page <product>
    And I click in button add to cart
    And I click in the cart
    Then I see the product in the cart
    Examples:
    |product|
    |"Sauce Labs Backpack"     |
    |"Sauce Labs Bike Light"   |
    |"Sauce Labs Bolt T-Shirt" |
    |"Sauce Labs Fleece Jacket"|
    |"Sauce Labs Onesie"       |
    |"Sauce Labs T-Shirt (Red)"|

  Scenario Outline: validate name product
    When I access the product page <product>
    Then I see the product name
    Examples:
    |product|
    |"Sauce Labs Backpack"     |