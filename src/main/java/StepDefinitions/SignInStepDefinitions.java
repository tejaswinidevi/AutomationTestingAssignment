package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import Pages.SignInPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.CommonUtility;
import io.cucumber.datatable.DataTable;

public class SignInStepDefinitions {
	
	SignInPage signInPage = new SignInPage();
	CommonUtility commonUtility = new CommonUtility();
	
	@When("^the user fills in the personal information with the following details on SignIn Page:$")
	public void fillDetailstoSignIn(DataTable userDetails) {
		Map<String,String> userDetailsForSignIn = userDetails.asMap(String.class,String.class);
		Map<String, String> updatedMap = commonUtility.mapWithaValues(userDetailsForSignIn);
		signInPage.fillInTheDetailsForSignIn(updatedMap);
	}
	
	@Then("^the user clicks on SignIn button$")
	public void clickSignInButton() {
		signInPage.clickSignInButton();
	}
	
	@Then("^the user sees the required field error msg on the following fields on SignIn Page:$")
	public void requiredFieldErrorMsgOnFields(DataTable fields) {
		Map<String,String> expectedFields = fields.asMap(String.class,String.class);
		expectedFields.forEach((field,expectation)->{
			assertEquals("Required Field is not filled",expectation,signInPage.checkForRequiredFieldErrorMsgOnField(field));
		});
	}
	
	@Then("^verfiy the signIn (successful|failed) with the msg '([\\w\\s\\S]+)'$")
	public void successfulAccountCreationMsg(String status,String msg) {
		assertEquals("Successfully Created an Account", msg, signInPage.signInAlertMsg(status));
	}
	
	@When("^the user clicks on Forgot Password$")
	public void clicksForgotPassword() {
		signInPage.clicksForgotPassword();
	}
}
