package examples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Parameters({"url", "username", "password"})
    @Test(groups = "smoke", priority = 1)
    
    public void loginTest(
        @Optional("https://the-internet.herokuapp.com/login") String url,
        @Optional("tomsmith") String username,
        @Optional("SuperSecretPassword!") String password
        
    ) {
        driver.get(url);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();

        // ✅ ASSERT LOGIN SUCCESS
        String successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash"))).getText();
        System.out.println("Message: " + successMsg);
        System.out.println("RUNNING FROM XML VERSION 2");


        Assert.assertTrue(successMsg.contains("You logged into a secure area!"),
                "Login failed! Message was: " + successMsg);
    }

    @Test(groups = "smoke", dependsOnMethods = "loginTest", priority = 2)
    public void logoutTest() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Logout"))).click();

        String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash"))).getText();
        System.out.println("Logout Message: " + msg);

        Assert.assertTrue(msg.contains("You logged out of the secure area!"),
                "Logout failed! Message was: " + msg);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
