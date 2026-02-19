package datadriventesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest1 {


    WebDriver driver;

    @DataProvider(name = "Book1")
    public Object[][] loginData() throws Exception {
        return ExcelUtil.getLoginData();
    }

    @Test(dataProvider = "Book1")
    public void loginTest(String username, String password) {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        System.out.println("Login attempted with: " + username + " | " + password);

        driver.quit();
}
}