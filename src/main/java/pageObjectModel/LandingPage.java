package pageObjectModel;

import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	
	 	WebDriver driver;

	    public LandingPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void GoTO() {
	        driver.get("https://magento.softwaretestingboard.com/");
	        driver.manage().window().maximize();
	    }

}
