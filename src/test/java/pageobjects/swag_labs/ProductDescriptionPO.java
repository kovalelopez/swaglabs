package pageobjects.swag_labs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.getElement;

public class ProductDescriptionPO {

    public WebElement getProductByDescriptionPage() {
        return getElement(By.className("inventory_details_container"));
    }

    public void validateProductName(String productDescription) {
        WebElement product = getProductByDescriptionPage();
        WebElement productName = product.findElement(
                By.className("inventory_details_name"));
        Assert.assertEquals(productName.getText(), productDescription, "Os nomes dos productos são" +
                "divergentes");
        appendToReportElementHighlight(productName);
    }

}
