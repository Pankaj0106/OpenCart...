package com.opencart.OpenCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterFunctionality {
	  public static void main(String[] args) {
	        
	        WebDriver driver = new ChromeDriver();

	        driver.get("https://demo.nopcommerce.com/");
	        System.out.println("Title: " + driver.getTitle());

	       // driver.quit();
	    }
}
