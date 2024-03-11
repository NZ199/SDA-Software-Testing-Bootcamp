package testPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testGoogleHomePage() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Title: " + title);
    }

    @Test
    public void testGoogleCurrentUrl() {
        driver.get("https://www.google.com");
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
    }
}