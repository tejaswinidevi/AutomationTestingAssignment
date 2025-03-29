package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinitions.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage extends BaseTest {
	
	public static String URL = "https://magento.softwaretestingboard.com/";
	public static String CreateAccount = "//a[contains(text(),'Create an Account')]";
	public static String signIn = "//a[contains(text(),'Sign In')]";

	public void loginToSoftwareTestingBoard() {
		driver.get(URL);
		System.out.println("Page Title: " + driver.getTitle());
	}
	
	public void clickOnCreateAccountInHomePage(String action) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		if(action.equalsIgnoreCase("Creates")) {
			WebElement createAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CreateAccount)));
			createAccount.click();
		}else if(action.equalsIgnoreCase("SignsIn")) {
			WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(signIn)));
			signInLink.click();
		}
	}
}
