package pageobjects.swag_labs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static driver.Drivers.getDriver;
import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.getElement;

public class ProductsPO {

    public void validateList() {
        appendToReportElementHighlight(getElement(By.className("inventory_list")));
        Assert.assertTrue(getElement(By.className("inventory_list")).isDisplayed(),
                "A lista de produtos não foi carregada");
    }

    public int countProducts(){
        return getDriver().findElements(By.className("inventory_item")).size();
    }

    public void validateProductsQuantity(int size){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        appendToReport();
        Assert.assertEquals(size,countProducts(),"A quantidade foi diferente");
    }

    public WebElement getProduct(String product) {
        List<WebElement> products = getDriver().findElements(By.className("inventory_item"));
        WebElement item = null;
        for (WebElement p:products
             ) {
            if (p.getText().contains(product)) {
                item = p;
                break;
            }
        }
        return item;
    }

    public String getPrice(String product) {
        WebElement item = getProduct(product);
        return item.findElement(By.className("inventory_item_price")).getText();
    }

    public void validatePriceProduct(String price, String product) {
        appendToReportElementHighlight(getProduct(product));
        Assert.assertTrue(getPrice(product).contains(price), "Os preços estão divergentes");
    }
    
}
