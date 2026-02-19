package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest1 {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // ✅ THIS METHOD IS MISSING IN YOUR CODE
    public WebDriver getDriver() {
        return driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {

        WebDriver localDriver;

        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                localDriver = new ChromeDriver();
                break;
            case "edge":

                System.setProperty("webdriver.edge.driver", "C:\\drivers\\msedgedriver.exe");

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");

                localDriver = new EdgeDriver(edgeOptions);
                break;


            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                localDriver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        localDriver.manage().window().maximize();
        driver.set(localDriver); // VERY IMPORTANT
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        driver.remove();
    }
}
