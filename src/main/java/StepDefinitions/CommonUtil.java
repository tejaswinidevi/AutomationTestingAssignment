package StepDefinitions;

import io.cucumber.java.en.When;
import util.CommonUtility;
import util.TestVariables;

public class CommonUtil {
	
	TestVariables testVariables;
	
	CommonUtility commonMethods = new CommonUtility();
	
	public CommonUtil() {
		this.testVariables = new TestVariables();
	}
	
	@When("^the user creates random alphanumericString of size (\\d+) and stores it to \\{(\\S*)\\}$")
	public void storeAlphaNumericStringIntoVariable(int size,String label) {
		String alphaNumericString = commonMethods.generateRandomAplhaNumericString(size);
		this.testVariables.store(label, alphaNumericString);
	}
	
	@When("^the user creates random mailId and stores it to \\{(\\S*)\\}$")
	public void storeRandomMaildIdIntoVariable(String label) {
		String mailId = commonMethods.generateRandomEmailId();
		this.testVariables.store(label, mailId);
	}
	
	@When("^the user creates random password of length (\\d+) and stores it to \\{(\\S*)\\}$")
	public void storeRandomPassword(int size,String label) { 
		String passcode = commonMethods.generateRandomPassword(size);
		this.testVariables.store(label, passcode);
	}

}
