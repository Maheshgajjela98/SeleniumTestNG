package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {
	@Test
	void verifyGoogleTitle() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		
		String actual = driver.getTitle();
		String expected = "Google";
		
		Assert.assertEquals(actual,expected,"title doesn't match!");
		Assert.assertTrue(actual.contains("Google"));
		Thread.sleep(3000);
		driver.quit();
	}
}
