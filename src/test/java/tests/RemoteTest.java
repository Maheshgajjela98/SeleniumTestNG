package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteTest{

    public static void main(String[] args) throws MalformedURLException {

    	String[] browsers = {"chrome", "edge", "firefox"};

    	for (String browser : browsers) {

    	    WebDriver driver = null;

    	    if (browser.equals("chrome")) {
    	        driver = new RemoteWebDriver(new URL("http://localhost:4444"), new ChromeOptions());
    	    } 
    	    else if (browser.equals("edge")) {
    	        driver = new RemoteWebDriver(new URL("http://localhost:4444"), new EdgeOptions());
    	    } 
    	    else if (browser.equals("firefox")) {
    	        driver = new RemoteWebDriver(new URL("http://localhost:4444"), new FirefoxOptions());
    	    }

    	    driver.get("https://www.google.com");
    	    System.out.println(browser + " Title: " + driver.getTitle());
    	    driver.quit();
    	}
    }
}