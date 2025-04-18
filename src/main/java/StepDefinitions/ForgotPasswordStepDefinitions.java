package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import Pages.ForgotPasswordPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.CommonUtility;
import io.cucumber.datatable.DataTable;

public class ForgotPasswordStepDefinitions {
	
	ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
	CommonUtility commonUtility = new CommonUtility();
	
	@When("^the user fills in the personal information with the following details on Forgot Password Page:$")
	public void fillDetailstoSignIn(DataTable userDetails) {
		Map<String,String> userDetailsForSignIn = userDetails.asMap(String.class,String.class);
		Map<String, String> updatedMap = commonUtility.mapWithaValues(userDetailsForSignIn);
		forgotPasswordPage.fillInTheDetailsForForgotPassword(updatedMap);
	}
	
	@Then("^the user clicks on Reset Password button$")
	public void clickSignInButton() {
		forgotPasswordPage.clickResetPassword();
	}
	
	@Then("^the user sees the required field error msg on the following fields on Forgot Password Page:$")
	public void requiredFieldErrorMsgOnFields(DataTable fields) {
		Map<String,String> expectedFields = fields.asMap(String.class,String.class);
		expectedFields.forEach((field,expectation)->{
			assertEquals("Required Field is not filled",expectation,forgotPasswordPage.checkForRequiredFieldErrorMsgOnField(field));
		});
	}
}
