package Pages;

import java.util.Map;

import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import StepDefinitions.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignInPage extends BaseTest {

	public static String email = "//input[@name='login[username]']";
	public static String password = "//input[@name='login[password]']";
	public static String createAnAccountButton = "//button[@name='send']";
	public static String emailErrorMsg = "//div[@id='email-error']";
	public static String passwordErrorMsg = "//div[@id='pass-error']";

	public void fillInTheDetailsForSignIn(Map<String, String> userDetails) {
		userDetails.forEach((key, value) -> {
			switch (key) {
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
			default:
				throw new RuntimeException("Invalid Input");
			}
		});
	}

	public void clickSignInButton() {
		driver.findElement(By.xpath(createAnAccountButton)).click();
	}

	public String checkForRequiredFieldErrorMsgOnField(String field) {
		switch (field) {
		case "Email":
			if (!driver.findElements(By.xpath(emailErrorMsg)).isEmpty()) {
				return driver.findElement(By.xpath(emailErrorMsg)).getText();
			} else {
				return "NA";
			}
		case "Password":
			if (!driver.findElements(By.xpath(passwordErrorMsg)).isEmpty()) {
				return driver.findElement(By.xpath(passwordErrorMsg)).getText();
			} else {
				return "NA";
			}
		default:
			throw new RuntimeException("Invalid Input");
		}
	}
}
