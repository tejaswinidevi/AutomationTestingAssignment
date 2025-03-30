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

public class ForgotPasswordPage extends BaseTest {

	public static String forgotPasswordTitle = "//span[text()='Forgot Your Password?']";
	public static String email = "//input[@id='email_address']";
	public static String resetPassword = "//button/span[text()='Reset My Password']";
	public static String emailErrorMsg = "//div[@id='email_address-error']";
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void fillInTheDetailsForForgotPassword(Map<String, String> userDetails) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(forgotPasswordTitle)));
		
		userDetails.forEach((key, value) -> {
			switch (key) {
			case "Email":
				if (value != null) {
					driver.findElement(By.xpath(email)).clear();
					driver.findElement(By.xpath(email)).sendKeys(userDetails.get("Email"));
				}
				break;
			default:
				throw new RuntimeException("Invalid Input");
			}
		});
	}

	public void clickResetPassword() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(forgotPasswordTitle)));
		driver.findElement(By.xpath(resetPassword)).click();
	}

	public String checkForRequiredFieldErrorMsgOnField(String field) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(forgotPasswordTitle)));
		switch (field) {
		case "Email":
			if (!driver.findElements(By.xpath(emailErrorMsg)).isEmpty()) {
				return driver.findElement(By.xpath(emailErrorMsg)).getText();
			} else {
				return "NA";
			}
		default:
			throw new RuntimeException("Invalid Input");
		}
	}
}
