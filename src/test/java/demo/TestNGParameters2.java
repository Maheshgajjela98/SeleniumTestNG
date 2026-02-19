package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGParameters2 {

	 WebDriver driver;

	    @BeforeMethod(alwaysRun = true)
	    public void setup() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://the-internet.herokuapp.com/login");
	    }

	    // ============ SMOKE ============
	    @Test(groups = "smoke")
	    public void smokeTest() {
	        System.out.println("SMOKE test executed");
	        Assert.assertTrue(true);
	    }

	    // ============ REGRESSION ============
	    @Test(groups = "regression")
	    public void regressionTest() {
	        System.out.println("REGRESSION test executed");
	        Assert.assertTrue(true);
	    }

	    // ============ FUNCTIONAL ============
	    @Test(groups = "functional")
	    public void functionalTest() {

	        System.out.println("FUNCTIONAL test executed");

	        driver.findElement(By.id("username")).sendKeys("tomsmith");
	        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	        driver.findElement(By.cssSelector("button[type='submit']")).click();

	        String msg = driver.findElement(By.id("flash")).getText();
	        System.out.println("Message: " + msg);

	        Assert.assertTrue(msg.contains("secure area"));
	    }

	    @AfterMethod(alwaysRun = true)
	    public void tearDown() {
	        driver.quit();
	    }
}
