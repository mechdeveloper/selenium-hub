package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class GoogleSearchTest {
    private WebDriver driver;

    // URL of the Selenium Grid Hub
    String hubUrl = "http://40.117.210.94:4444";
    
    @Before
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Run in headless mode
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        driver = new RemoteWebDriver(new URL(hubUrl), options);

        // DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setBrowserName("chrome");
        // driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
    }

    @Test
    public void testGoogleSearch() {
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium Grid");
        searchBox.submit();
        System.out.println("Title in Chrome: " + driver.getTitle());
        assertEquals("Selenium Grid - Google Search", driver.getTitle());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
