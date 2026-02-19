package tests;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import base.BaseTest;
	import pages.LoginPage1;
	public class LoginTest1 extends BaseTest {

	    @Test
	    public void loginTest() {

	        LoginPage1 loginPage = new LoginPage1(driver);

	        loginPage.login("standard_user", "secret_sauce");

	        // Assertion - Verify Login Success
	        String expectedUrl = "https://www.saucedemo.com/inventory.html";
	        String actualUrl = loginPage.getCurrentUrl();

	        Assert.assertEquals(actualUrl, expectedUrl, "Login Failed - URL not matched");
	    }
	}
