package apachepoi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;

public class SearchTableValue {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/html_tables.asp");

        // Locate table
        WebElement table = driver.findElement(By.id("customers"));

        // Get all rows
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        String searchValue = "Germany";
        boolean found = false;

        // Loop through rows
        for (int i = 1; i < rows.size(); i++) {

            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

           String company = columns.get(0).getText();
           String contact = columns.get(1).getText();
           String country = columns.get(2).getText();

            // Search condition
            if (country.equalsIgnoreCase(searchValue)) {

                System.out.println("Match Found!");
                System.out.println(company + " | " + contact + " | " + country);

                found = true;
            }
        }

        if (!found) {
            System.out.println("Value not found in table");
        }

        driver.quit();
    }
}

