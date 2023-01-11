package gherkin.stepdefinition.swag_labs_steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

}
