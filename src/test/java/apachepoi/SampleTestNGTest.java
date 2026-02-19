package apachepoi;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class SampleTestNGTest {

    WebDriver driver;
    private static final Logger logger =
            LogManager.getLogger(SampleTestNGTest.class);

    @BeforeMethod
    public void setUp() {
        logger.info("Browser setup started");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void googleTest() {
        logger.info("Test started");

        driver.get("https://www.google.com");

        // ❌ Intentional failure
        driver.findElement(null);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        // Screenshot only if test fails
        if (ITestResult.FAILURE == result.getStatus()) {
            SeleniumScreenshotUtil
                    .captureFailureScreenshot(driver, result.getName());
        }

        if (driver != null) {
            driver.quit();
        }

        logger.info("Browser closed");
    }
}
