package pomexample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	// constructor
	LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	// Locators
	By txt_username=By.id("username");
	By txt_password=By.id("password");
	By btn_login=By.cssSelector("button[type='submit']");
	
	//Action methods
	
	public void setUserName(String user) 
	{
	     driver.findElement(txt_username).sendKeys(user);	
	}
	
	public void setPassword(String pwd) 
	{
		driver.findElement(txt_password).sendKeys(pwd);
	}
	
	public void clickLogin() {
		driver.findElement(btn_login).click();
	}
}
