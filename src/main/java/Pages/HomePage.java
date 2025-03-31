package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinitions.BaseTest;
import Locators.Locators;

public class HomePage extends BaseTest {

	public void loginToSoftwareTestingBoard() {
		driver.get(Locators.HOMEPAGE_URL);
		System.out.println("Page Title: " + driver.getTitle());
	}

	public void clickOnCreateAccountInHomePage(String action) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		if (action.equalsIgnoreCase("Creates")) {
			WebElement createAccount = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.HOMEPAGE_CREATEACCOUNT)));
			createAccount.click();
		} else if (action.equalsIgnoreCase("SignsIn")) {
			WebElement signInLink = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.HOMEPAGE_SIGNIN)));
			signInLink.click();
		}
	}
}
