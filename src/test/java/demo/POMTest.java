package demo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class POMTest {

	WebDriver driver;
	@BeforeClass
	void setup() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	@Test
	void TestLogin() {
		POMPage pp = new POMPage(driver);
		pp.setUserName("Admin");
		pp.setPassword("admin123");
		pp.clicklogin();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");

	}
	@AfterClass
	void teadDown() {
		driver.quit(); }
	
}
