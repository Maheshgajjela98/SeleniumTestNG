
package pomexample;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage1_PF {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage1_PF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);   // Initialize PageFactory elements
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators using @FindBy

    @FindBy(id = "user-name")
    WebElement txt_username;

    @FindBy(id = "password")
    WebElement txt_password;

    @FindBy(id = "login-button")
    WebElement btn_login;

    // Action Methods

    public void setUserName(String user) {
        wait.until(ExpectedConditions.visibilityOf(txt_username)).sendKeys(user);
    }

    public void setPassword(String pwd) {
        wait.until(ExpectedConditions.visibilityOf(txt_password)).sendKeys(pwd);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_login)).click();
    }
}

