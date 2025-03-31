package Pages;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinitions.BaseTest;
import Locators.Locators;

public class CreateCustomerAccountPage extends BaseTest {

	WebElement firstName = driver.findElement(By.xpath(Locators.CREATEACCOUNT_FIRSTNAME));
	WebElement lastName = driver.findElement(By.xpath(Locators.CREATEACCOUNT_LASTNAME));
	WebElement email = driver.findElement(By.xpath(Locators.CREATEACCOUNT_EMAIL));
	WebElement password = driver.findElement(By.xpath(Locators.CREATEACCOUNT_PASSWORD));
	WebElement confirmPassword = driver.findElement(By.xpath(Locators.CREATEACCOUNT_CONFIRMPASSWORD));

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void fillInTheDetailsForNewCustomerAccount(Map<String, String> userDetails) {
		userDetails.forEach((key, value) -> {
			switch (key) {
			case "First Name":
				if (value != null) {
					firstName.clear();
					firstName.sendKeys(userDetails.get("First Name"));
				}

				break;
			case "Last Name":
				if (value != null) {
					lastName.clear();
					lastName.sendKeys(userDetails.get("Last Name"));
				}
				break;
			case "Email":
				if (value != null) {
					email.clear();
					email.sendKeys(userDetails.get("Email"));
				}
				break;
			case "Password":
				if (value != null) {
					password.clear();
					password.sendKeys(userDetails.get("Password"));
				}
				break;
			case "Confirm Password":
				if (value != null) {
					confirmPassword.clear();
					confirmPassword.sendKeys(userDetails.get("Confirm Password"));
				}
				break;
			default:
				throw new RuntimeException("Invalid Input");
			}
		});
	}

	public void clickCreateanAccountButton() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.CREATEACCOUNT_CREATEANACCOUNTBUTTON)))
				.click();
	}

	public String checkForRequiredFieldErrorMsgOnField(String field, String expecetedErrorMsg) {
		switch (field) {
		case "First Name":
			if (!expecetedErrorMsg.equalsIgnoreCase("NA")) {
				return wait
						.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath(Locators.CREATEACCOUNT_FIRSTNAME_ERRORMSG)))
						.getText();
			} else {
				if (driver.findElements(By.xpath(Locators.CREATEACCOUNT_FIRSTNAME_ERRORMSG)).isEmpty()) {
					return "NA";
				}
			}
		case "Last Name":
			if (!expecetedErrorMsg.equalsIgnoreCase("NA")) {
				return wait
						.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath(Locators.CREATEACCOUNT_LASTNAME_ERRORMSG)))
						.getText();
			} else {
				if (driver.findElements(By.xpath(Locators.CREATEACCOUNT_LASTNAME_ERRORMSG)).isEmpty()) {
					return "NA";
				}
			}
		case "Email":
			if (!expecetedErrorMsg.equalsIgnoreCase("NA")) {
				return wait.until(
						ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.CREATEACCOUNT_EMAIL_ERRORMSG)))
						.getText();
			} else {
				if (driver.findElements(By.xpath(Locators.CREATEACCOUNT_EMAIL_ERRORMSG)).isEmpty()) {
					return "NA";
				}
			}
		case "Password":
			if (!expecetedErrorMsg.equalsIgnoreCase("NA")) {
				return wait
						.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath(Locators.CREATEACCOUNT_PASSWORD_ERRORMSG)))
						.getText();
			} else {
				if (driver.findElement(By.xpath(Locators.CREATEACCOUNT_PASSWORD_ERRORMSG)).getAttribute("style")
						.equals("display: none;")) {
					return "NA";
				}
			}
		case "Confirm Password":
			if (!expecetedErrorMsg.equalsIgnoreCase("NA")) {
				return wait
						.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath(Locators.CREATEACCOUNT_CONFIRMPASSWORD_ERRORMSG)))
						.getText();
			} else {
				if (driver.findElements(By.xpath(Locators.CREATEACCOUNT_CONFIRMPASSWORD_ERRORMSG)).isEmpty()) {
					return "NA";
				}
			}
		default:
			throw new RuntimeException("Invalid Input");
		}
	}

	public String getPasswordStrength() {
		return wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.CREATEACCOUNT_PASSWORD_STRENGTHMETER)))
				.getText();
	}
}
