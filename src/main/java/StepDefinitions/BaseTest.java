package StepDefinitions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected static WebDriver driver;

    @Before
    public void setUp() {
    	if (driver == null) {
    		WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
    	}
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
