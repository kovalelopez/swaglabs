package pageobjects.swag_labs;

import org.openqa.selenium.By;
import org.testng.Assert;

import static report.Report.appendToReport;
import static report.Report.appendToReportElementHighlight;
import static utils.Utils.getElement;

public class ProductsPO {

    public void validateList() {
        appendToReportElementHighlight(getElement(By.className("inventory_list")));
        Assert.assertTrue(getElement(By.className("inventory_list")).isDisplayed(),
                "A lista de produtos não foi carregada");
    }

}
