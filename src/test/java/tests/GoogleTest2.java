package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest2;

public class GoogleTest2 extends BaseTest2 {

	 @Test
	    public void verifyTitle() {

	        driver.get("https://www.google.com");

	        String title = driver.getTitle();
	        System.out.println("Title: " + title);
	        System.out.println("Current URL: " + driver.getCurrentUrl());
	        System.out.println("Title: " + driver.getTitle());


	        Assert.assertTrue(title.contains("Google"));
	    }
}
