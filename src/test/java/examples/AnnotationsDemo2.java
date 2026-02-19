package examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsDemo2 {

	 WebDriver driver;

	    @BeforeClass
	    void setup() throws InterruptedException {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        System.out.println("BeforeClass - Browser Launched");

	        Thread.sleep(3000);
	    }

	    @BeforeMethod
	    void openApp() throws InterruptedException {
	        driver.get("https://www.facebook.com");
	        System.out.println("BeforeMethod - Open Facebook");

	        Thread.sleep(3000);
	    }

	    @Test
	    void verifyTitle() throws InterruptedException {
	        String title = driver.getTitle();
	        System.out.println("Test - Page Title is: " + title);

	        Assert.assertTrue(title.contains("Facebook"), "Title does not contain Facebook");

	        Thread.sleep(2000);
	    }

	    @AfterMethod
	    void afterTest() throws InterruptedException {
	        System.out.println("AfterMethod - Test Finished");

	        Thread.sleep(2000);
	    }

	    @AfterClass
	    void tearDown() throws InterruptedException {
	        driver.quit();
	        System.out.println("AfterClass - Browser Closed");
	    }
	}

