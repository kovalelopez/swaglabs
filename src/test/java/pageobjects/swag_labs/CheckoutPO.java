package pageobjects.swag_labs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

import static driver.Drivers.getDriver;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.*;

public class CheckoutPO {

    public void validateCheckoutPage() {
        validatePage(xpathContains("Checkout: Overview".toUpperCase()), "0");
    }

    public String getTotalPrice() {
        WebElement elementTotalPrice = getElement(By.className("summary_subtotal_label"));
        new Actions(getDriver()).moveToElement(elementTotalPrice).build().perform();
        String totalPrice = elementTotalPrice.getText();
        return totalPrice;
    }

    public void validateTotalPrice(List<String> prices) {
        Float sumPrices = 0.00f;
        for (String price:prices
             ) {
            sumPrices = sumPrices + castToFloat(price.replace("$", ""));
        }
        Assert.assertTrue(getTotalPrice().contains(sumPrices.toString()),
                "Total price is different");
        appendToReportElementHighlight(getElement(By.className("summary_subtotal_label")));
    }



}
