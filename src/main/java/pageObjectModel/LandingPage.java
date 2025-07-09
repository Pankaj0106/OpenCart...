package pageObjectModel;

import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class LandingPage {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void GoTO() {
        String url = ConfigReader.getProperty("url");
        driver.get(url);
        driver.manage().window().maximize();
    }
}
