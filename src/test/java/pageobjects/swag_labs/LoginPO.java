package pageobjects.swag_labs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static report.Report.appendToReport;
import static utils.Utils.*;

public class LoginPO {

    public void validateLoginPage() {
        Assert.assertTrue(getElement(By.className("login_logo")).isDisplayed(),
                "Não foi possível validar a página ");
        appendToReport();
    }

    public void insertUserName(String userName) {
        elementSendKeys(By.id("user-name"), userName);
    }

    public void insertPassword(String password) {
        elementSendKeys(By.id("password"), password);
    }

    public void loginBtn() {
        elementClick(By.id("login-button"));
    }

    public void validateLogin() {
        Assert.assertTrue(getElement(By.className("title")).isDisplayed(),
                "Login não foi efetuado");
    }

    public void validateLoginWithoutCredentials(String message) {
        WebElement errorMessage = getElement(By.cssSelector("#login_button_container > div > form" +
                " > div.error-message-container.error > h3"));
        Assert.assertTrue(errorMessage.getText().contains(message));
    }

    public void validateLoginWithoutPassword(String message) {
        WebElement errorMessage = getElement(By.cssSelector("#login_button_container > div > form" +
                " > div.error-message-container.error > h3"));
        Assert.assertTrue(errorMessage.getText().contains(message),
                "Erro: a mensagem de login sem senha está diferente");
    }

    public void validateLoginWithInvalidCredentials(String message) {
        WebElement errorMessage = getElement(By.cssSelector("#login_button_container > div > form" +
                " > div.error-message-container.error > h3"));
        Assert.assertTrue(errorMessage.getText().contains(message),
                "Erro: a mensagem de login com credenciais inválidas está diferente");
    }

}


