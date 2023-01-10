package gherkin.stepdefinition.swag_labs_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.swag_labs.LoginPO;

public class NoCredentialsLoginSteps {

    LoginPO loginPO;

    @When("I dont fill credentials")
    public void i_dont_fill_credentials() {
        loginPO = new LoginPO();
        loginPO.insertUserName("");
        loginPO.insertPassword("");

    }

    @And("I click the button login")
    public void i_click_the_button_login() {
        loginPO.loginBtn();

    }

    @Then("I see the message {string}")
    public void i_see_the_message(String message) {
        loginPO.validateLoginWithoutCredentials(message);

    }
}
