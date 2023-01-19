package gherkin.stepdefinition.swag_labs_steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pageobjects.swag_labs.CartPO;
import pageobjects.swag_labs.CheckoutPO;
import pageobjects.swag_labs.ClientInformationPO;
import pageobjects.swag_labs.ProductsPO;

import java.util.List;
public class CheckoutSteps {

    ProductsPO productsPO;
    List<String> listProducts;
    List<String> listPrices;
    @When("I add the products")
    public void i_add_the_products(io.cucumber.datatable.DataTable dataTable) {
        productsPO = new ProductsPO();
        listProducts = dataTable.asList();
        listPrices = productsPO.getPrices(listProducts);
        productsPO.addProducts(listProducts);
    }
    CartPO cartPO;
    @When("I validate the products in the cart")
    public void i_validate_the_products_in_the_cart() {
        cartPO = new CartPO();
        productsPO.accessCart();
        cartPO.validateProductsAndCheckout(listProducts);
    }
    ClientInformationPO clientInformationPO;
    @When("I fill the checkout form with {string}, {string} and {string}")
    public void i_fill_the_checkout_form_with_and(String name, String lastName, String postalCode) {
        clientInformationPO = new ClientInformationPO();
        clientInformationPO.sendForm(name, lastName, postalCode);
    }
    CheckoutPO checkoutPO;
    @Then("I see the order total price")
    public void i_see_the_order_total_price() {
        checkoutPO = new CheckoutPO();
        checkoutPO.validateTotalPrice(listPrices);
    }

}
