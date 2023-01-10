package gherkin.stepdefinition.swag_labs_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.swag_labs.LoginPO;

public class LoginSteps {

    LoginPO loginPO;


    @When("I make login")
    public void i_make_login() {
        loginPO.insertUserName("standard_user");
        loginPO.insertPassword("secret_sauce");
        loginPO.loginBtn();
    }
//    @Then("I see the swag labs logo")
//    public void i_see_the_swag_labs_logo() {
//       loginPO.validateLogin();
//    }

}
