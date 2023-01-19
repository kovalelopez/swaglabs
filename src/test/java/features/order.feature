Feature: Order
  Background: realized login
    Given I am logged in swag labs with username "standard_user" and password "secret_sauce"
  Scenario Outline: validate total price
    When I add the products
    |Sauce Labs Backpack|
    |Sauce Labs Bolt T-Shirt|
    |Sauce Labs Fleece Jacket|
    And I validate the products in the cart
    * I fill the checkout form with <name>, <lastName> and <postalCode>
    Then I see the order total price
    Examples:
    |name     |lastName|postalCode|
    |"William"|"Soares"|"12345678"|