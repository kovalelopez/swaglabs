package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ResultSalaryPO {

    WebDriver driver;

    public ResultSalaryPO(WebDriver driver) {
        this.driver = driver;
    }

    public void closePopup() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Actions actions = new Actions(driver);
        actions.click().build().perform();
    }

    public String getNetSalary() {
        String netSalary = driver.findElement(By.id("total-gross-salary-liquid")).getText();
        return netSalary;
    }

    public void validateNetSalary(String expectedNetSalary) {
        closePopup();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(getNetSalary(), expectedNetSalary);
    }

}
