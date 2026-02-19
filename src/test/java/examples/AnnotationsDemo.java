package examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AnnotationsDemo {

    WebDriver driver;

    @BeforeClass
    void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("BeforeClass - Browser Launched");

        Thread.sleep(5000); 
    }

    @BeforeMethod
    void openApp() throws InterruptedException {
        driver.get("https://www.google.com");
        System.out.println("BeforeMethod - Open Google");

        Thread.sleep(3000); 
    }

    @Test 
    void testTitle() throws InterruptedException {
        System.out.println("Test - Title is: " + driver.getTitle());

        Thread.sleep(2000); 
    }

    @AfterMethod
    void afterTest() throws InterruptedException {
        System.out.println("AfterMethod - Test Finished");

        Thread.sleep(2000); 
    }

    @AfterClass
    void tearDown() throws InterruptedException {
        Thread.sleep(2000); 
        driver.quit();
        System.out.println("AfterClass - Browser Closed");
    }
}
