package Pages;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Locators.Locators;
import StepDefinitions.BaseTest;

public class ForgotPasswordPage extends BaseTest {

	WebElement email = driver.findElement(By.xpath(Locators.FORGOTPASSWORD_EMAIL));
	WebElement resetPassword = driver.findElement(By.xpath(Locators.FORGOTPASSWORD_RESETPASSWORD));

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void fillInTheDetailsForForgotPassword(Map<String, String> userDetails) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.FORGOTPASSWORD_TITLE)));

		userDetails.forEach((key, value) -> {
			switch (key) {
			case "Email":
				if (value != null) {
					email.clear();
					email.sendKeys(userDetails.get("Email"));
				}
				break;
			default:
				throw new RuntimeException("Invalid Input");
			}
		});
	}

	public void clickResetPassword() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.FORGOTPASSWORD_TITLE)));
		resetPassword.click();
	}

	public String checkForRequiredFieldErrorMsgOnField(String field) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.FORGOTPASSWORD_TITLE)));
		switch (field) {
		case "Email":
			if (!driver.findElements(By.xpath(Locators.FORGOTPASSWORD_EMAIL_ERRORMSG)).isEmpty()) {
				return driver.findElement(By.xpath(Locators.FORGOTPASSWORD_EMAIL_ERRORMSG)).getText();
			} else {
				return "NA";
			}
		default:
			throw new RuntimeException("Invalid Input");
		}
	}
}
