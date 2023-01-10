Feature: Login swag labs
  Background: accessed swag labs site
    Given I accessed the swag labs site

  Scenario: basic login
    When  I make login
    Then  I see the swag labs logo

   Scenario: login without credentials
    When I dont fill credentials
    And  I click the button login
    Then I see the message "Epic sadface: Username is required"

  Scenario: login without password
    When I fill user name field
    And  I dont fill password field
    And  I click the login button
    Then I see a message "Epic sadface: Password is required"

  Scenario: login with invalid credentials
    When I make login with invalid credentials
    Then I see a new message "Epic sadface: Username and password do not match any user in this service"

