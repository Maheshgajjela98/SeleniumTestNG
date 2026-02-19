package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POMPage {

	WebDriver driver;
	POMPage(WebDriver driver){
		this.driver=driver;
	}
	// Locators
	By username = By.name("username");
	By password = By.name("password");
	By loginBtn = By.cssSelector("button[type='submit']");

	// Action methods
	public void setUserName(String user) {
		driver.findElement(username).sendKeys(user);
	}
	public void setPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void clicklogin() {
		driver.findElement(loginBtn).click();
	}
}
