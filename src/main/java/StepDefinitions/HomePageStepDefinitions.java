package StepDefinitions;

import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStepDefinitions {
	
	HomePage homePage = new HomePage();
	
	@Given("^the user navigates to the software testing board home page$")
	public void loginToSoftwareTestingBoard() {
		homePage.loginToSoftwareTestingBoard();
	}
	
	@Then("^the user (Creates|SignsIn) an Account$")
	public void createAccount(String action) throws InterruptedException {
		homePage.clickOnCreateAccountInHomePage(action);
	}
}
