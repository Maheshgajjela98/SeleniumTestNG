package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameters {

	WebDriver driver ;
	@BeforeMethod(alwaysRun = true)
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://the-internet.herokuapp.com/login");
	}
	@Test(groups = "smoke")
	@Parameters({"username","password"})
	public void login(String user,String pass) {
		 driver.findElement(By.id("username")).sendKeys(user);
	     driver.findElement(By.id("password")).sendKeys(pass);
	     driver.findElement(By.cssSelector("button[type='submit']")).click();

	        String msg = driver.findElement(By.id("flash")).getText();
	        System.out.println("Valid Login Message: " + msg);

	        Assert.assertTrue(msg.contains("secure area"),"Expected success message but got: " + msg);
	}
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
	 @AfterMethod(alwaysRun = true)
	 public void teardown() {
		 driver.quit();
	 }
}
