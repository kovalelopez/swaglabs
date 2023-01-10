Feature: Products list
  Background: accessed swag labs site
    Given I accessed the swag labs site

    Scenario Outline: List validation
      When I make login with username <username> and password <password>
      Then I see product list
      Examples:
      |username         |password      |
      |"standard_user"  |"secret_sauce"|
