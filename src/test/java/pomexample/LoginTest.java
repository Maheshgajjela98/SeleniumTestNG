package pomexample;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	@BeforeClass
	void setup()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/login");
		
	}
	@Test
	void testLogin() 
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName("tomsmith");
		lp.setPassword("SuperSecretPassword!");
		lp.clickLogin();
		
		Assert.assertEquals(driver.getTitle(),"The Internet");
	}
	@AfterClass
	void teadDown() 
	{
		driver.quit();
	}
}
