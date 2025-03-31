package StepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import Pages.MyAccountPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.TestVariables;
import io.cucumber.datatable.DataTable;

public class MyAccountStepDefinitions {

	MyAccountPage userProfilePage = new MyAccountPage();

	@Then("^verfiy the account creation (successful|failed) with the msg '([\\w\\s\\S]+)'$")
	public void successfulAccountCreationMsg(String status,String msg) {
		assertEquals("Successfully Created an Account", msg, userProfilePage.AccountCreationAlertMsg(status));
	}

	@Then("^verify the contact details with the following data:$")
	public void newUserDetails(DataTable newUserDetails) {
		Map<String, String> userDetails = newUserDetails.asMap(String.class, String.class);
		userDetails.forEach((key, value) -> {
			switch (key) {
			case "Name":
				String fullName = "";
				String[] values = value.split(" ");
				for (int i = 0; i < values.length; i++) {
					fullName += TestVariables.map.containsKey(values[i].replace("{", "").replace("}", "").trim())
							? TestVariables.map.get(values[i].replace("{", "").replace("}", "").trim()).toString()
							: values[i];
					if (i != values.length - 1) {
						fullName += " ";
					}
				}
				assertTrue(userProfilePage.getName().contains(fullName));
				break;
			case "Email":
				assertTrue(userProfilePage.getEmail()
						.contains(TestVariables.map.containsKey(value.replace("{", "").replace("}", "").trim())
								? TestVariables.map.get(value.replace("{", "").replace("}", "").trim()).toString()
								: value));
			}
		});
	}
	
	@When("^the user signs out of the account$")
	public void signOut() {
		userProfilePage.signOut();
	}
}
