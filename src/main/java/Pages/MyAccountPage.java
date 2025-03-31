package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinitions.BaseTest;
import Locators.Locators;

public class MyAccountPage extends BaseTest {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public String AccountCreationAlertMsg(String status) {
		if (status.equalsIgnoreCase("successful")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.MYACCOUNT_TITLE)));
		} else if (status.equalsIgnoreCase("failed")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.MYACCOUNT_ALERT)));
		}
		return driver.findElement(By.xpath(Locators.MYACCOUNT_ALERT)).getText();
	}

	public String getName() {
		return driver.findElement(By.xpath(Locators.MYACCOUNT_BOXCONTENT)).getText();
	}

	public String getEmail() {
		return driver.findElement(By.xpath(Locators.MYACCOUNT_BOXCONTENT)).getText();
	}

	public void signOut() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.MYACCOUNT_CUSTOMER_WELCOME_DROPDOWN)));
		driver.findElement(By.xpath(Locators.MYACCOUNT_CUSTOMER_WELCOME_DROPDOWN)).click();
		driver.findElement(By.xpath(Locators.MYACCOUNT_SIGNOUT)).click();
	}
}
