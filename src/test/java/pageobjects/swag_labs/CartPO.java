package pageobjects.swag_labs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static driver.Drivers.getDriver;
import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.getElement;
import static utils.Utils.validatePage;

public class CartPO {

    public void validateCartPage() {
        String title = getElement(By.className("title")).getText();
        appendToReport();
        Assert.assertEquals(title.toLowerCase(), "your cart",
                "Não foi possível acessar o carrinho de compras");
    }

    public WebElement getProductCart(String product) {
        List<WebElement> list = getDriver().findElements(By.className("cart_item"));
        WebElement item = null;
        boolean flag = false;
        for (WebElement element:list
             ) {
            if (element.getText().contains(product)) {
                item = element;
                flag = true;
            }
        }
        Assert.assertTrue(flag, "O produto não foi adicionado no carrinho");
        return item;
    }

    public void validateProductCart(String product) {
        appendToReportElementHighlight(getProductCart(product));
        Assert.assertNotNull(getProductCart(product), "O produto não foi adicionado no carrinho");
    }

}
