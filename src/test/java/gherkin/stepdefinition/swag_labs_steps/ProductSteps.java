package gherkin.stepdefinition.swag_labs_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.swag_labs.LoginPO;
import pageobjects.swag_labs.ProductsPO;

public class ProductSteps {

    ProductsPO productsPO;

    @Then("I see product list")
    public void i_see_product_list() {
        productsPO = new ProductsPO();
        productsPO.validateList();
    }

    @Then("Validate the quantity of products")
    public void validate_the_quantity_of_products() {
        productsPO = new ProductsPO();
        productsPO.validateProductsQuantity(6);
    }
    @Given("I am logged in swag labs with username {string} and password {string}")
    public void i_am_logged_in_swag_labs_with_username_and_password(String username, String password) {
        LoginPO loginPO = new LoginPO();
        loginPO.login(username, password);
    }
    String product;
    @When("Select the product {string}")
    public void select_the_product(String product) {
        productsPO = new ProductsPO();
        this.product = product;
        productsPO.getProduct(this.product);
    }
    @When("I get the price")
    public void i_get_the_price() {
        productsPO.getPrice(this.product);
    }
    @Then("Validate the price is correct {string}")
    public void validate_the_price_is_correct(String price) {
        productsPO.validatePriceProduct(price, this.product);
    }


    @When("I add the product in the cart")
    public void i_add_the_product_in_the_cart() {
        productsPO.addProduct(this.product);
    }
    @Then("I see the text {string} in the button")
    public void i_see_the_text_in_the_button(String text) {
        productsPO.validateAddCartText(this.product, text);
    }
    @Then("I see the product in the cart")
    public void i_see_the_product_in_the_cart() {
    }

}
