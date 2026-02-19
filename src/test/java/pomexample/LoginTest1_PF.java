package pomexample;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class LoginTest1_PF {

	    WebDriver driver;

	    @BeforeClass
	    void setup() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.saucedemo.com/");
	    }

	    @Test
	    void testLogin() {
	        LoginPage1_PF lp = new LoginPage1_PF(driver);

	        lp.setUserName("standard_user");
	        lp.setPassword("secret_sauce");
	        lp.clickLogin();

	        // Validation
	        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
	    }

	    @AfterClass
	    void tearDown() {
	        driver.quit();
	    }
	}
