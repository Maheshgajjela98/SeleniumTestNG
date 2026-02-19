package examples;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SimpleLoginTest2 {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)   // ✅ VERY IMPORTANT
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    // ============ SMOKE ============
    @Test(groups = "smoke")
    @Parameters({"username", "password"})
    public void validLoginTest(String user, String pass) {

        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String msg = driver.findElement(By.id("flash")).getText();
        System.out.println("Valid Login Message: " + msg);

        Assert.assertTrue(msg.contains("secure area"),
                "Expected success message but got: " + msg);
    }

    // ============ REGRESSION ============
    @Test(groups = "regression")
    @Parameters({"username", "password"})
    public void invalidLoginTest(String user, String pass) {

        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String msg = driver.findElement(By.id("flash")).getText();
        System.out.println("Invalid Login Message: " + msg);

        Assert.assertTrue(msg.toLowerCase().contains("invalid"),
                "Expected error message but got: " + msg);
    }

    @AfterMethod(alwaysRun = true)   // ✅ VERY IMPORTANT
    public void tearDown() {
        driver.quit();
    }
}
