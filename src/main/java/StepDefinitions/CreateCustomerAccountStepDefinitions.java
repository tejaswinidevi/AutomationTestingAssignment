package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.stream.Collectors;

import Pages.CreateCustomerAccountPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.TestVariables;
import io.cucumber.datatable.DataTable;

public class CreateCustomerAccountStepDefinitions {

	CreateCustomerAccountPage createNewCustomerAccount = new CreateCustomerAccountPage();

	@When("^the user fills in the personal information with the following details:$")
	public void fillDetailstoCreateNewCustomerAccount(DataTable userDetails) {
		Map<String, String> userDetailsForAccountCreation = userDetails.asMap(String.class, String.class);
		Map<String, String> updatedMap = userDetailsForAccountCreation.entrySet().stream()
				.filter(entry -> entry.getValue() != null).collect(Collectors.toMap(Map.Entry::getKey, // Extract key as
																										// is
						entry -> TestVariables.map
								.containsKey(entry.getValue().replace("{", "").replace("}", "").trim())
										? TestVariables.map
												.get(entry.getValue().replace("{", "").replace("}", "").trim())
												.toString()
										: entry.getValue().toString()));
		createNewCustomerAccount.fillInTheDetailsForNewCustomerAccount(updatedMap);
	}

	@Then("^the user clicks on Create an Account button$")
	public void clickCreateanAccountButton() {
		createNewCustomerAccount.clickCreateanAccountButton();
	}

	@Then("^the user sees the required field error msg on the following fields:$")
	public void requiredFieldErrorMsgOnFields(DataTable fields) {
		Map<String, String> expectedFields = fields.asMap(String.class, String.class);
		expectedFields.forEach((field, expectation) -> {
			assertEquals("Required Field is not filled", expectation,
					createNewCustomerAccount.checkForRequiredFieldErrorMsgOnField(field,expectation));
		});
	}

	@Then("^the user checks the password strength to be (Weak|Medium|Strong|Very Strong)$")
	public void verifyPasswordStrength(String strength) {
		switch (strength) {
		case "Weak":
			assertEquals("Password Strength Validation", "Password Strength: Weak",
					createNewCustomerAccount.getPasswordStrength());
			break;
		case "Medium":
			assertEquals("Password Strength Validation", "Password Strength: Medium",
					createNewCustomerAccount.getPasswordStrength());
			break;
		case "Strong":
			assertEquals("Password Strength Validation", "Password Strength: Strong",
					createNewCustomerAccount.getPasswordStrength());
			break;
		case "Very Strong":
			assertEquals("Password Strength Validation", "Password Strength: Very Strong",
					createNewCustomerAccount.getPasswordStrength());
			break;
		default:
			throw new RuntimeException("Invalid Input");
		}

	}
}
