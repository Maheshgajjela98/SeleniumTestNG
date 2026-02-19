package apachepoi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleSeleniumTest {

    private static final Logger logger =
            LogManager.getLogger(SampleSeleniumTest.class);

    public static void main(String[] args) {

        WebDriver driver = null;

        try {
            logger.info("Test execution started");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.get("https://www.google.com");

            // ❌ Intentional failure
            driver.findElement(null);

        } catch (Exception e) {
            logger.error("Test failed due to exception", e);

            SeleniumScreenshotUtil
                    .captureFailureScreenshot(driver, "GoogleTest");

        } finally {
            if (driver != null) {
                driver.quit();
            }
            logger.info("Test execution finished");
        }
    }
}

