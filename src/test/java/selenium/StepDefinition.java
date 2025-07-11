// selenium/StepDefinition.java
package selenium;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import utils.LoggerHelper;

import base.BaseClass;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import pageObjectModel.LandingPage;
import pageObjectModel.Register;

public class StepDefinition {

    LandingPage page;
    Register register;
    Logger log = (Logger) LoggerHelper.getLogger(StepDefinition.class);

    @Given("I landed on Ecommerce page")
    public void i_landed_on_ecommerce_page() {
    	log.info("Launching Ecommerce website...");
        page = new LandingPage(BaseClass.driver);
        page.GoTO();
    }

    @When("Navigate to Create an Account section")
    public void navigate_to_create_an_account_section() {
    	  log.info("Navigating to create an account...");
        register = new Register(BaseClass.driver);
        register.ClickRegister();
    }

    @Then("Input all the required field")
    public void input_all_the_required_field(DataTable dataTable) {
    	  log.info("Input all the required fields...");
        List<Map<String, String>> userData = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = userData.get(0);

        register = new Register(BaseClass.driver);
        register.closePopupIfPresent();
        register.FillForm(data.get("First Name"), data.get("Last Name"), data.get("Email"),
                          data.get("Password"), data.get("Confirm Password"));
    }

    @Then("User click on Create an account button")
    public void user_click_on_create_an_account_button() {
    	  log.info("click on Create an account button...");
        register.ClickCreateBtn();
    }

    @Then("user verify success message {string}")
    public void user_verify_success_message(String expectedMsg) {
    	 log.info("user verify success message...");
        register.ValidateRegisterSuceess(expectedMsg);
    }
}
