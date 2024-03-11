package testPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestPages{
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up the WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testWebAutomation() {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        WebElement locatorsLink = driver.findElement(By.linkText("Locators - Find By Playground Test Page"));
        locatorsLink.click();

        System.out.println("Current URL: " + driver.getCurrentUrl());
        // Print the URL

        // Navigate back
        driver.navigate().back();

        // Print the URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Click on "WebDriver Example Page"
        WebElement webDriverLink = driver.findElement(By.linkText("WebDriver Example Page"));
        webDriverLink.click();

        // Print the URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Enter value '20' in the "Enter Some Numbers inputBox"
        WebElement inputBox = driver.findElement(By.id("inputNumbers"));
        inputBox.sendKeys("20");
        inputBox.submit();

        // Verify 'two, zero' message is displayed on the page
        WebElement message = driver.findElement(By.id("message"));
        String displayedMessage = message.getText();
        if (displayedMessage.equals("two, zero")) {
            System.out.println("Verification successful: 'two, zero' message is displayed.");
        } else {
            System.out.println("Verification failed: Expected 'two, zero' message not found.");
        }
    }

    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}