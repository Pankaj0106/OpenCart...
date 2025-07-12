Feature: To register a user

Scenario: Verify user is able to register with valid input 
	Given I landed on Ecommerce page 
	When Navigate to Create an Account section
	Then Input all the required field
	|First Name	|	Last Name	|	Email					|	Password	|	Confirm Password	|
	|	Pankaj		|	Bhatt			| p28@gmail.com	|	P@123456	|	P@123456					|
	Then User click on Create an account button
	Then user verify success message "Thank you for registering with Main Website Store."
