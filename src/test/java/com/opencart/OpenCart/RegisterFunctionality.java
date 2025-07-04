package com.opencart.OpenCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class RegisterFunctionality {
	  public static void main(String[] args) {
	        
	        WebDriver driver = new EdgeDriver();

	        driver.get("https://magento.softwaretestingboard.com/");
	        System.out.println("Title: " + driver.getTitle());

	       // driver.quit();
}
}