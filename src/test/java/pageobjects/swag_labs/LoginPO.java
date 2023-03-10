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

    public void login(String username, String password) {
        insertUserName(username);
        insertPassword(password);
        appendToReport();
        loginBtn();
    }

    public void validateLogin(String message) {
        Assert.assertTrue(getElement(By.className("title")).getText().
                        toLowerCase().contains(message.toLowerCase()),
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
    public void validateLoginLockedUser(String message) {
        WebElement errorMessage = getElement(By.cssSelector("#login_button_container > div > form" +
                " > div.error-message-container.error > h3"));
        Assert.assertTrue(errorMessage.getText().contains(message),
                "Erro: a mensagem de login com credenciais inválidas está diferente");
    }

    public void validateLoginSwagLabs(String username, String password, String message) {
        appendToReport();
        if (username.isEmpty() && password.isEmpty()) {
            validateLoginWithoutCredentials(message);
        } else if (!username.isEmpty() && password.isEmpty()) {
            validateLoginWithoutPassword(message);
        } else if (!username.isEmpty() && !password.isEmpty()) {
            if (isElementPresent(By.cssSelector("#header_container > div.header_secondary_container > span"))) {
                validateLogin(message);
            } else if (username.contains("locked_out_user")) {
                validateLoginLockedUser(message);
            } else {
                validateLoginWithInvalidCredentials(message);
            }
        }
    }

    public void validatedLogin(String username, String password, String message) {
        login(username, password);
        validateLoginSwagLabs(username, password, message);
    }

}


