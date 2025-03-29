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

public class UserProfilePage extends BaseTest {

	public static String alert = "//div[@role='alert']";
	public static String boxContent = "//div[@class='box-content']";
	public static String myAccountPageTitle = "//h1[@class='page-title']";
	public static String customerWelcomeDropDown = "//button[@data-action='customer-menu-toggle'] [@class='action switch']";
	public static String signOut = "//li[@class=\"authorization-link\"]//a[contains(text(), 'Sign Out')]";
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public String AccountCreationAlertMsg(String status) {
		if(status.equalsIgnoreCase("successful")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(myAccountPageTitle)));
		}else if(status.equalsIgnoreCase("failed")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(alert)));
		}
		return driver.findElement(By.xpath(alert)).getText();
	}

	public String getName() {
		return driver.findElement(By.xpath(boxContent)).getText();
	}

	public String getEmail() {
		return driver.findElement(By.xpath(boxContent)).getText();
	}
	
	public void signOut() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(customerWelcomeDropDown)));
		driver.findElement(By.xpath(customerWelcomeDropDown)).click();
		driver.findElement(By.xpath(signOut)).click();
	}
}
