package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

public class BaseClass {
    public static WebDriver driver;
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    static {
        System.setProperty("log4j.configurationFile", "src/test/java/resources/log4j2.xml");
    }

    public static WebDriver initDriver() {
        ConfigReader.loadConfig();
        String browser = ConfigReader.getProperty("browser");

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid browser in config. Defaulting to Chrome.");
                driver = new ChromeDriver();
                break;
        }

        driver.manage().window().maximize();
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            tlDriver.remove();
        }
    }
}
