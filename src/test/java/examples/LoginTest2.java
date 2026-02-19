package examples;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest2 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();   // ✅ FIX: auto setup driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    // ========================= SMOKE TEST =========================
    @Test(groups = "smoke")
    @Parameters({"username", "password"})
    public void validLoginTest(String user, String pass) {

        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String msg = driver.findElement(By.id("flash")).getText();
        System.out.println("Valid Login Message: " + msg);

        Assert.assertTrue(msg.contains("You logged into a secure area!"),
                "Expected success message but got: " + msg);
    }

    // ====================== REGRESSION TEST ======================
    @Test(groups = "regression")
    @Parameters({"username", "password"})
    public void invalidLoginTest(String user, String pass) {

        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String msg = driver.findElement(By.id("flash")).getText();
        System.out.println("Invalid Login Message: " + msg);

        Assert.assertTrue(msg.contains("Your username is invalid!"),
                "Expected error message but got: " + msg);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
