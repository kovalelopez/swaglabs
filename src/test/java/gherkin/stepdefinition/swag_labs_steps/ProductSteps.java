package gherkin.stepdefinition.swag_labs_steps;

import io.cucumber.java.en.Then;
import pageobjects.swag_labs.ProductsPO;

public class ProductSteps {

    ProductsPO productsPO;

    @Then("I see product list")
    public void i_see_product_list() {
        productsPO = new ProductsPO();
        productsPO.validateList();
    }

}
