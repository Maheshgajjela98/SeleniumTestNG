package examples;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ParallelFacebookTest {
	 @Test
	    void verifyFacebookTitle() throws InterruptedException {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("https://www.facebook.com");
	        Thread.sleep(5000);

	        String actualTitle = driver.getTitle();
	        Assert.assertTrue(actualTitle.contains("Facebook"), "Title does not contain Facebook!");
	        Thread.sleep(5000);

	        driver.quit();
	    }
	}



