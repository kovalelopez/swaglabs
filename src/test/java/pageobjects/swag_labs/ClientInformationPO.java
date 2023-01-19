package pageobjects.swag_labs;

import org.openqa.selenium.By;

import static report.Report.appendToReport;
import static utils.Utils.*;

public class ClientInformationPO {

    public void validatePageClientInformation() {
        validatePage(xpathContains("Checkout: Your Information".toUpperCase()), "0");
    }

    public void setName(String name) {
        elementSendKeys(By.id("first-name"), name);
    }
    public void setLastName(String lastName) {
        elementSendKeys(By.id("last-name"), lastName);
    }
    public void setPostalCode(String postalCode) {
        elementSendKeys(By.id("postal-code"), postalCode);
    }
    public void btnCancel() {
        elementClick(By.id("cancel"));
    }
    public void btnContinue() {
        elementClick(By.id("continue"));
    }
    public void fillForm(String name, String lastName, String postalCode) {
        setName(name);
        setLastName(lastName);
        setPostalCode(postalCode);
        appendToReport("Filled form");
    }
    public void sendForm(String name, String lastName, String postalCode) {
        fillForm(name, lastName, postalCode);
        btnContinue();
    }

}
