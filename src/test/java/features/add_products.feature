Feature: Adicionar produtos no carrinho de compras
  Scenario: Adicionar produtos no carrinho na listagem
    Given I am logged in swag labs with username "standard_user" and password "secret_sauce"
    When Select the product "Sauce Labs Fleece Jacket"
    And I add the product in the cart
    Then I see the text "REMOVE" in the button

  Scenario: Adicionar produtos no carrinho
    Given I am logged in swag labs with username "standard_user" and password "secret_sauce"
    When Select the product "Sauce Labs Fleece Jacket"
    And I add the product in the cart
    And I click in the cart
    Then I see the product in the cart