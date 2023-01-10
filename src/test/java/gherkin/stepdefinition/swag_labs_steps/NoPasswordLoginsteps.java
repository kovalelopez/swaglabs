package gherkin.stepdefinition.swag_labs_steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.swag_labs.LoginPO;

public class NoPasswordLoginsteps {

    LoginPO loginPO;

    @When("I fill user name field")
    public void i_fill_user_name_field() {
        loginPO = new LoginPO();
        loginPO.insertUserName("standard_user");
    }
    @And("I dont fill password field")
    public void i_dont_fill_password_field() {
        loginPO.insertPassword("");
    }
    @And("I click the login button")
    public void i_click_the_login_button() {
        loginPO.loginBtn();
    }
    @Then("I see a message {string}")
    public void i_see_a_message(String message) {
        loginPO.validateLoginWithoutPassword(message);
    }

}
