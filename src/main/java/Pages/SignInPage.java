package Pages;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinitions.BaseTest;
import Locators.Locators;

public class SignInPage extends BaseTest {

	WebElement email = driver.findElement(By.xpath(Locators.SIGNIN_EMAIL));
	WebElement password = driver.findElement(By.xpath(Locators.SIGNIN_PASSWORD));
	WebElement createAnAccountButton = driver.findElement(By.xpath(Locators.SIGNIN_CREATE_AN_ACCOUNT_BUTTON));
	WebElement myAccountPageTitle = driver.findElement(By.xpath(Locators.MYACCOUNT_TITLE));
	WebElement forgortPassword = driver.findElement(By.xpath(Locators.SIGNIN_FORGOT_PASSWORD));

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public void fillInTheDetailsForSignIn(Map<String, String> userDetails) {
		userDetails.forEach((key, value) -> {
			switch (key) {
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
			default:
				throw new RuntimeException("Invalid Input");
			}
		});
	}

	public void clickSignInButton() {
		createAnAccountButton.click();
	}

	public String checkForRequiredFieldErrorMsgOnField(String field) {
		switch (field) {
		case "Email":
			if (!driver.findElements(By.xpath(Locators.SIGNIN_EMAIL_ERRORMSG)).isEmpty()) {
				return driver.findElement(By.xpath(Locators.SIGNIN_EMAIL_ERRORMSG)).getText();
			} else {
				return "NA";
			}
		case "Password":
			if (!driver.findElements(By.xpath(Locators.SIGNIN_PASSWORD_ERRORMSG)).isEmpty()) {
				return driver.findElement(By.xpath(Locators.SIGNIN_PASSWORD_ERRORMSG)).getText();
			} else {
				return "NA";
			}
		default:
			throw new RuntimeException("Invalid Input");
		}
	}

	public String signInAlertMsg(String status) {
		if (status.equalsIgnoreCase("successful")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.MYACCOUNT_TITLE)));
		} else if (status.equalsIgnoreCase("failed")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.MYACCOUNT_ALERT)));
		}
		return driver.findElement(By.xpath(Locators.MYACCOUNT_ALERT)).getText();
	}

	public void clicksForgotPassword() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.SIGNIN_FORGOT_PASSWORD)));
		forgortPassword.click();
	}
}
