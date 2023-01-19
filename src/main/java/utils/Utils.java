package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static driver.Drivers.getDriver;
import static report.Report.appendToReportElementHighlight;

public class Utils {

    public static void scrollPage(String pixels) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("window.scrollBy(0," + pixels + ")");
    }

    public static WebElement getElement(By by) {
        WebElement element = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }

    public static List<WebElement> getElements(WebElement father, By by) {
        List<WebElement> list = father.findElements(by);
        return list;
    }

    public static void elementClick(By by) {
        WebElement element = getElement(by);
        element.click();
    }

    public static void elementClear(By by) {
        WebElement element = getElement(by);
        element.clear();
    }

    public static void elementSendKeys(By by, String text) {
        WebElement element = getElement(by);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public static void elementSendKeys(By by, String text, Keys key) {
        WebElement element = getElement(by);
        element.click();
        element.clear();
        element.sendKeys(text, key);
    }

    public static void validatePage(By by, String pixels) {
        WebElement element = getElement(by);
        scrollPage(pixels);
        Assert.assertTrue(element.isDisplayed(), "Elemento ausente");
        appendToReportElementHighlight(element);
    }

    /**
     * @param by - será utilizado para efetuar uma busca de um elemento
     *           Este método retorna true ou false ao invés de gerar uma exception
     *           quando o elemento não é encontrado
     * */
    public static boolean isElementPresent(By by) {
        boolean isPresent = false;
        try {
            getDriver().findElement(by);
            isPresent = true;
        }catch (Exception e) {
            isPresent = false;
        }
        return isPresent;
    }

    /**
     * @param seconds - quantidade de segundos que a automação será congelada
     * */
    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param text - texto que será utilizado como parâmetro no contains do xpath
     *             Este método retorna o BY que será utilizado no método findElement()
     *             ou findElements()
     * */
    public static By xpathContains(String text) {
        return By.xpath("//*[contains(text(),'" +text+"')]");
    }

    /**
     * @param value - valor do tipo String que será convertido para ponto flutuante (float)
     * @return retorna o valor convertido para float
     * */
    public static Float castToFloat(String value) {
        return Float.parseFloat(value);
    }

}
