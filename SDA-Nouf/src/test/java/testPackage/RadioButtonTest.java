package testPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/** Task 1:
Go to URL: https://demoqa.com/radio-button
Verify whether all 3 options given to the question can be selected.
When each option is selected, print the following texts on the console.*/
public  class RadioButtonTest {
    public WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
    }

    @Test
    public void radio1(){
        By radio1 = By.xpath("//label[@class='custom-control-label' and @for='yesRadio']");
        driver.findElement(radio1).click();
        var actualMsg = driver.findElement(By.xpath("//p[@class='mt-3']")).getText();
        Assertions.assertEquals("You have selected Yes", actualMsg);
        System.out.println(actualMsg);
    }
    @Test
    public void radio2(){
        By radio2 = By.xpath("//label[@class='custom-control-label' and @for='impressiveRadio']");
        driver.findElement(radio2).click();
        var actualMsg = driver.findElement(By.xpath("//p[@class='mt-3']")).getText();
        Assertions.assertEquals("You have selected Impressive", actualMsg);
    }

    //Third radio button "NO" can't able to click




    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
