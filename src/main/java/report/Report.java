package report;

import com.cucumber.listener.Reporter;
import driver.Drivers;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Report {

    public static String takeScreenshot() {
        return ((TakesScreenshot) Drivers.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

    public static void appendToReport() {
        Reporter.addStepLog("<div align=\"right\"><ul class='screenshots right'><li>" +
                "<img data-featherlight=\"image\" href=\"data:image/png;base64, " + takeScreenshot() + "\"  " +
                "src=\"data:image/png;base64, " + takeScreenshot() + "\" alt=\"Red dot\" width=\"5%\" />" +
                "</img></li></ul></div>");
    }

}
