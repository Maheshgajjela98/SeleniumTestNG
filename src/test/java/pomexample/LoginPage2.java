package pomexample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2{

    WebDriver driver;

    // Constructor
    public LoginPage2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }

    // Locators using @FindBy annotation

    @FindBy(id = "username")
    WebElement txt_username;

    @FindBy(id = "password")
    WebElement txt_password;

    @FindBy(css = "button[type='submit']")
    WebElement btn_login;

    // Action Methods

    public void setUserName(String user) {
        txt_username.sendKeys(user);
    }

    public void setPassword(String pwd) {
        txt_password.sendKeys(pwd);
    }

    public void clickLogin() {
        btn_login.click();
    }
}

