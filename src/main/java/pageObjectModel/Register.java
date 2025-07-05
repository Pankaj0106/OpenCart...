// pageObjectModel/Register.java
package pageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import org.testng.Assert;

import utils.ScreenshotUtil;

public class Register {
    WebDriver driver;

    // Constructor
    public Register(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(linkText = "Create an Account")
    WebElement createAccountLink;

    @FindBy(id = "firstname")
    WebElement FirstName;

    @FindBy(name = "lastname")
    WebElement LastName;

    @FindBy(id = "email_address")
    WebElement Email;

    @FindBy(id = "password")
    WebElement Password;

    @FindBy(name = "password_confirmation")
    WebElement ConfirmPassword;

    @FindBy(css = ".action.submit.primary")
    WebElement createBtn;

    @FindBy(css = ".message-success.success.message")
    WebElement successMsg;

    // Actions
    public void ClickRegister() {
        createAccountLink.click();
    }

    public void FillForm(String firstName, String lastName, String email, String password, String confirmPassword) {
        FirstName.sendKeys(firstName);
        LastName.sendKeys(lastName);
        Email.sendKeys(email);
        Password.sendKeys(password);
        ConfirmPassword.sendKeys(confirmPassword);
    }

    public void ClickCreateBtn() {
        createBtn.click();
    }

    public void ValidateRegisterSuceess(String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(successMsg));

        String actualText = successMsg.getText().trim();

        if (!actualText.equalsIgnoreCase(expectedText)) {
            ScreenshotUtil.captureScreenshot("ErrorMessageMismatch");
            Assert.fail("Expected message:\n" + expectedText + "\n\nBut found:\n" + actualText);
        } else {
            System.out.println("✅ Success message matched.");
        }
    }

    public void closePopupIfPresent() {
        try {
            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

            for (WebElement frame : iframes) {
                driver.switchTo().frame(frame);

                List<WebElement> popup = driver.findElements(By.id("dismiss-button"));

                if (!popup.isEmpty()) {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                    wait.until(ExpectedConditions.elementToBeClickable(popup.get(0))).click();
                    System.out.println("Popup dismissed.");
                    driver.switchTo().defaultContent();
                    break;
                }

                driver.switchTo().defaultContent();
            }
        } catch (Exception e) {
            System.out.println("No popup or failed to dismiss: " + e.getMessage());
            driver.switchTo().defaultContent();
        }
    }
}
