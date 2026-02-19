package apachepoi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class TableHandling {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/html_tables.asp");

        // Locate the table
        WebElement table = driver.findElement(By.id("customers"));

        // Get all rows
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size(); i++) { // skip header
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

            String company = columns.get(0).getText();
            String contact = columns.get(1).getText();
            String country = columns.get(2).getText();

            System.out.println(company + " | " + contact + " | " + country);
        }

        // Get all links on page 
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links: " + links.size());

        for (WebElement link : links) {
            System.out.println(link.getText() + " -> " + link.getAttribute("href"));
        }

        driver.quit();
    }
}
