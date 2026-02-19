package examples;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ParallelGoogleTest {
	@Test
    void verifyGoogleTitle() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");
        Thread.sleep(5000);

        String actual = driver.getTitle();
        String expected = "Google";

        Assert.assertEquals(actual, expected, "Title does not match!");
        Thread.sleep(5000);

        driver.quit();
    }
}


