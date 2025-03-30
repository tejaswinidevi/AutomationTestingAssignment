package Pages;

import java.time.Duration;
import java.util.Map;

import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinitions.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewCustomerAccountPage extends BaseTest {

	public static String firstName = "//input[@name='firstname']";
	public static String lastName = "//input[@name='lastname']";
	public static String email = "//input[@name='email']";
	public static String password = "//input[@name='password']";
	public static String confirmPassword = "//input[@name='password_confirmation']";
	public static String createAnAccountButton = "//button[@title='Create an Account']";
	public static String firstNameErrorMsg = "//div[@id='firstname-error']";
	public static String lastNameErrorMsg = "//div[@id='lastname-error']";
	public static String emailErrorMsg = "//div[@id='email_address-error']";
	public static String passwordErrorMsg = "//div[@id='password-error']";
	public static String confirmPasswordErrorMsg = "//div[@id='password-confirmation-error']";
	public static String passwordStrengthMeter = "//div[@id='password-strength-meter-container']";

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void fillInTheDetailsForNewCustomerAccount(Map<String, String> userDetails) {
		userDetails.forEach((key, value) -> {
			switch (key) {
			case "First Name":
				if (value != null) {
					driver.findElement(By.xpath(firstName)).clear();
					driver.findElement(By.xpath(firstName)).sendKeys(userDetails.get("First Name"));
				}

				break;
			case "Last Name":
				if (value != null) {
					driver.findElement(By.xpath(lastName)).clear();
					driver.findElement(By.xpath(lastName)).sendKeys(userDetails.get("Last Name"));
				}
				break;
			case "Email":
				if (value != null) {
					driver.findElement(By.xpath(email)).clear();
					driver.findElement(By.xpath(email)).sendKeys(userDetails.get("Email"));
				}
				break;
			case "Password":
				if (value != null) {
					driver.findElement(By.xpath(password)).clear();
					driver.findElement(By.xpath(password)).sendKeys(userDetails.get("Password"));
				}
				break;
			case "Confirm Password":
				if (value != null) {
					driver.findElement(By.xpath(confirmPassword)).clear();
					driver.findElement(By.xpath(confirmPassword)).sendKeys(userDetails.get("Confirm Password"));
				}
				break;
			default:
				throw new RuntimeException("Invalid Input");
			}
		});
	}

	public void clickCreateanAccountButton() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createAnAccountButton)));
		driver.findElement(By.xpath(createAnAccountButton)).click();
	}

	public String checkForRequiredFieldErrorMsgOnField(String field, String expecetedErrorMsg) {
		switch (field) {
		case "First Name":
			if (!expecetedErrorMsg.equalsIgnoreCase("NA")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(firstNameErrorMsg)));
				return driver.findElement(By.xpath(firstNameErrorMsg)).getText();
			} else {
				if (driver.findElements(By.xpath(firstNameErrorMsg)).isEmpty()) {
					return "NA";
				}
			}
		case "Last Name":
			if (!expecetedErrorMsg.equalsIgnoreCase("NA")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(lastNameErrorMsg)));
				return driver.findElement(By.xpath(lastNameErrorMsg)).getText();
			} else {
				if (driver.findElements(By.xpath(lastNameErrorMsg)).isEmpty()) {
					return "NA";
				}
			}
		case "Email":
			if (!expecetedErrorMsg.equalsIgnoreCase("NA")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(emailErrorMsg)));
				return driver.findElement(By.xpath(emailErrorMsg)).getText();
			} else {
				if (driver.findElements(By.xpath(emailErrorMsg)).isEmpty()) {
					return "NA";
				}
			}
		case "Password":
			if (!expecetedErrorMsg.equalsIgnoreCase("NA")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(passwordErrorMsg)));
				return driver.findElement(By.xpath(passwordErrorMsg)).getText();
			} else {
				if (driver.findElement(By.xpath(passwordErrorMsg)).getAttribute("style").equals("display: none;")) {
					return "NA";
				}
			}
		case "Confirm Password":
			if (!expecetedErrorMsg.equalsIgnoreCase("NA")) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(confirmPasswordErrorMsg)));
				return driver.findElement(By.xpath(confirmPasswordErrorMsg)).getText();
			} else {
				if (driver.findElements(By.xpath(confirmPasswordErrorMsg)).isEmpty()) {
					return "NA";
				}
			}
		default:
			throw new RuntimeException("Invalid Input");
		}
	}

	public String getPasswordStrength() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(passwordStrengthMeter)));
		return driver.findElement(By.xpath(passwordStrengthMeter)).getText();
	}
}
