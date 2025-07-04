package selenium;

import io.cucumber.java.en.*;
import pageObjectModel.LandingPage;

public class StepDefinition {
	
	LandingPage page;

	@Given("I landed on Ecommerce page")
	public void i_landed_on_ecommerce_page() {
	   page.GoTO();
	}
	@When("Navigate to Create an Account section")
	public void navigate_to_create_an_account_section() {
	   // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Input all the required field")
	public void input_all_the_required_field(io.cucumber.datatable.DataTable dataTable) {
	   
	}
	@Then("User click on Create an account button")
	public void user_click_on_create_an_account_button() {
	    
	}
	@Then("user verify success message {string}")
	public void user_verify_success_message(String string) {
	    
	}

}
