package examples;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*  login---->@BeforeMethod
    search ----@Test
    logout ----@AfterMethod
    login ----
    adv search ---@Test
    logout ---
 */

public class TestNGDemo {
     @BeforeMethod
	void login() {
		System.out.println("This is login..");
	}
	@Test(priority=1)
	void search(){
		System.out.println("This is search...");
	}
	@Test(priority=2)
	void advsearch(){
		System.out.println("advsearch...");
	}
	@AfterMethod
	void logout() {
		System.out.println("This is logout..");
	}
}
