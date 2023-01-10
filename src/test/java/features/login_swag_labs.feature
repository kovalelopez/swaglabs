Feature: Login swag labs
  Background: accessed swag labs site
    Given I accessed the swag labs site

    Scenario Outline: Login validations
      When I make login with username <username> and password <password>
      Then I see the message <message>
      Examples:
      |username         |password      |message   |
      |"standard_user"  |"secret_sauce"|"Products"|
      |"locked_out_user"  |"secret_sauce"|"Epic sadface: Sorry, this user has been locked out."|
      |"problem_user"  |"secret_sauce"|"Products"|
      |"performance_glitch_user"  |"secret_sauce"|"Products"|
      |""               |""            |"Epic sadface: Username is required"|
      |"standard_user"  |""            |"Epic sadface: Password is required"|
      |"mentor"         |"growdev"     |"Epic sadface: Username and password do not match any user in this service"|
