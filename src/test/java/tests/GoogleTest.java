package tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest1;

public class GoogleTest extends BaseTest1 {

    @Test
    public void verifyTitle() {

    	 getDriver().get("https://www.google.com");

    	 getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    	 String title = getDriver().getTitle();
         System.out.println("Title: " + title);

         Assert.assertTrue(title.contains("Google"));
     }
}

