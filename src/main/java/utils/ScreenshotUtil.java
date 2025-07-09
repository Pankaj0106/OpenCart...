package utils;

import base.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void captureScreenshot(String scenarioName) {
        WebDriver driver = BaseClass.driver;

        if (driver == null) {
            System.out.println("Driver is null. Cannot take screenshot.");
            return;
        }

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = "screenshots/" + scenarioName + "_" + timeStamp + ".png";

            Files.createDirectories(Paths.get("screenshots"));
            Files.write(Paths.get(fileName), screenshot);

            System.out.println("Screenshot captured: " + fileName);

        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
