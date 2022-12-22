package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NetSalaryPO {

    WebDriver driver;

    public NetSalaryPO(WebDriver driver) {
        this.driver = driver;
    }

    public void setSalary(String salary) {
        driver.findElement(By.id("form-sl-gross-salary")).sendKeys(salary);
    }

    public void setDiscounts(String discounts) {
        driver.findElement(By.id("form-sl-discounts")).sendKeys(discounts);
    }

    public void setDependents(String numberDependents) {
        WebElement dependent = driver.findElement(By.id("form-sl-number-dependents"));
        dependent.click();
        dependent.clear();
        dependent.sendKeys(numberDependents);
    }

    public void btnCalculate() {
        driver.findElement(By.id("btnSend")).click();
    }

}
