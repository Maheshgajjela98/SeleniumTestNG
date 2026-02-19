package examples;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest1 {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test(groups = {"smoke", "regression"})
    @Parameters({"username", "password"})
    public void loginTest(String user, String pass) {

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();

        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String msg = driver.findElement(By.id("flash")).getText();
        System.out.println("Message: " + msg);

        // ✅ ASSERTION LOGIC
        if (user.equals("tomsmith")) {
            Assert.assertTrue(msg.contains("You logged into a secure area!"),
                    "Expected success message but got: " + msg);
        } else {
            Assert.assertTrue(msg.contains("Your username is invalid!"),
                    "Expected error message but got: " + msg);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
