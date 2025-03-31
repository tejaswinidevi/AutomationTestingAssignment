package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinitions.BaseTest;
import Locators.Locators;

public class MyAccountPage extends BaseTest {

	WebElement alert = driver.findElement(By.xpath(Locators.MYACCOUNT_ALERT));
	WebElement boxContent = driver.findElement(By.xpath(Locators.MYACCOUNT_BOXCONTENT));
	WebElement myAccountPageTitle = driver.findElement(By.xpath(Locators.MYACCOUNT_TITLE));
	WebElement customerWelcomeDropDown = driver.findElement(By.xpath(Locators.MYACCOUNT_CUSTOMER_WELCOME_DROPDOWN));
	WebElement signOut = driver.findElement(By.xpath(Locators.MYACCOUNT_SIGNOUT));

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public String AccountCreationAlertMsg(String status) {
		if (status.equalsIgnoreCase("successful")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.MYACCOUNT_TITLE)));
		} else if (status.equalsIgnoreCase("failed")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.MYACCOUNT_ALERT)));
		}
		return alert.getText();
	}

	public String getName() {
		return boxContent.getText();
	}

	public String getEmail() {
		return boxContent.getText();
	}

	public void signOut() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.MYACCOUNT_CUSTOMER_WELCOME_DROPDOWN)));
		customerWelcomeDropDown.click();
		signOut.click();
	}
}
