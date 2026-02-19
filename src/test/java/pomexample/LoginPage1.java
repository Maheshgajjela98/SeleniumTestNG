package pomexample;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class LoginPage1 {

	    WebDriver driver;
	    WebDriverWait wait;

	    // Constructor
	    LoginPage1(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    // Locators
	    By txt_username = By.id("user-name");
	    By txt_password = By.id("password");
	    By btn_login = By.id("login-button");

	    // Action methods

	    public void setUserName(String user) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_username)).sendKeys(user);
	    }

	    public void setPassword(String pwd) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_password)).sendKeys(pwd);
	    }

	    public void clickLogin() {
	        wait.until(ExpectedConditions.elementToBeClickable(btn_login)).click();
	    }
	}

