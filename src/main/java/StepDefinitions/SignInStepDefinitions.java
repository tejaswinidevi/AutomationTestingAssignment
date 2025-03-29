package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Pages.CreateNewCustomerAccountPage;
import Pages.HomePage;
import Pages.SignInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.TestVariables;
import io.cucumber.datatable.DataTable;

public class SignInStepDefinitions {
	
	SignInPage signInPage = new SignInPage();
	
	@When("^the user fills in the personal information with the following details on SignIn Page:$")
	public void fillDetailstoSignIn(DataTable userDetails) {
		Map<String,String> userDetailsForSignIn = userDetails.asMap(String.class,String.class);
		Map<String,String> updatedMap = userDetailsForSignIn.entrySet().stream().filter(entry -> entry.getValue() != null)
			    .collect(Collectors.toMap(
			        Map.Entry::getKey,  // Extract key as is
			        entry -> TestVariables.map.containsKey(entry.getValue().replace("{", "").replace("}", "").trim()) ? TestVariables.map.get(entry.getValue().replace("{", "").replace("}", "").trim()).toString() : entry.getValue().toString()
			    ));
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
}
