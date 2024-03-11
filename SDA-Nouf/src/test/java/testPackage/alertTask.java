package testPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class alertTask {
    public WebDriver driver;
    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Alerts.html");

    }
    @Test
    public void AlertOKTest() {
        //Click "Alert with OK" and click 'click the button to display an alert box:
        WebElement OkButton = driver.findElement(By.id("OKTab"));
        OkButton.click();
        // Accept Alert (I am an alert box!) and print alert on console
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        alert.accept();
    }
    @Test
    public void AlertWithOkCancelTest() {
        // Click "Alert with OK & Cancel" and click 'click the button to display a confirmation box
        By alertWithOkAndCancel = By.xpath("//a[@href='#CancelTab']");
        driver.findElement(alertWithOkAndCancel).click();
        By alertWithOkAndCancelButton = By.xpath("//button[@onclick='confirmbox()']");
        driver.findElement(alertWithOkAndCancelButton).click();

        // Wait for the alert and switch to it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Cancel the alert (Press a Button !)
        alert.dismiss();

        // Get the message displayed after dismissing the alert
        By message = By.xpath("//p[@id='demo']");
        String actualMessage = driver.findElement(message).getText();
        System.out.println(actualMessage);
    }
    @Test
    public void AlertWithTextBoxLinkTest() {
        // Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box
        By alertLink = By.xpath("//a[@href='#Textbox']");
        driver.findElement(alertLink).click();
        By alertButton = By.xpath("//button[@onclick='promptbox()']");
        driver.findElement(alertButton).click();

        // Switch to the alert
        Alert alert = driver.switchTo().alert();

        // sendKeys «Bootcamp» (Please enter your name) alert
        alert.sendKeys("«Bootcamp» Nouf Alsubhi");
        alert.accept();

        // Finally, print this message on the console: "Hello Bootcamp How are you today" and assert this message.
        By message1 = By.xpath("//p[@id='demo1']");
        String actualMessage1 = driver.findElement(message1).getText();
        // print on console this message "Hello Bootcamp How are you today" assertion these message
        System.out.println(actualMessage1);
        Assertions.assertEquals("Hello «Bootcamp» Nouf Alsubhi How are you today", actualMessage1);
    }
    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

}
