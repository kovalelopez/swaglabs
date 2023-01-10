package gherkin.stepdefinition.swag_labs_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.swag_labs.LoginPO;

public class LoginSwagLabsSteps {

    String user;
    String pass;
    LoginPO loginPO;

    @Given("I accessed the swag labs site")
    public void i_accessed_the_swag_labs_site() {
        loginPO = new LoginPO();
        loginPO.validateLoginPage();
    }

    @When("I make login with username {string} and password {string}")
    public void i_make_login_with_username_and_password(String username, String password) {
        user = username;
        pass = password;
        loginPO.login(user, pass);
    }

    @Then("I see the message {string}")
    public void i_see_the_message(String message) {
        loginPO.validateLoginSwagLabs(user, pass, message);
    }

}
