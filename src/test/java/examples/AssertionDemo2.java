package examples;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo2 {
	 @Test
	    void verifyFacebookPage() throws InterruptedException {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("https://www.facebook.com");
	        Thread.sleep(3000);

	        // Verify Title
	        String actualTitle = driver.getTitle();
	        String expectedTitle = "Facebook – log in or sign up";

	        Assert.assertEquals(actualTitle, expectedTitle, "❌ Title does not match!");

	        // Verify URL
	        String actualURL = driver.getCurrentUrl();
	        Assert.assertTrue(actualURL.contains("facebook.com"), "❌ URL does not contain facebook!");

	        System.out.println("✅ All assertions passed!");

	        Thread.sleep(3000);
	        driver.quit();
	 }
}
