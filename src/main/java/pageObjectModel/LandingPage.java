package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPage {
	
	
	public void GoTO() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
	}

}
