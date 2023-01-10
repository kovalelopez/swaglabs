package gherkin.stepdefinition.swag_labs_steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.swag_labs.LoginPO;

public class InvalidCredentialsLoginSteps {

    LoginPO loginPO;

    @When("I make login with invalid credentials")
    public void i_make_login_with_invalid_credentials() {
        loginPO = new LoginPO();
        loginPO.insertUserName("big chester");
        loginPO.loginBtn();
    }
//    @Then("I see a new message {string}")
//    public void i_see_a_new_message(String message) {
//       loginPO.validateLoginWithInvalidCredentials(message);
//    }

}
