package testPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class DropDownTest {
    public WebDriver driver;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");

    }
    @Test
    public void DropDown(){
        // Find the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("oldSelectMenu"));

        // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Get all the options of the dropdown
        java.util.List<WebElement> options = dropdown.getOptions();

        // Options size
        int optionsSize = options.size();
        System.out.println("Options size: " + optionsSize);

        // Print all options
        System.out.println("Options:");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        // Verify if the dropdown has the option "Black"
        boolean isBlackPresent = false;
        for (WebElement option : options) {
            if (option.getText().equals("Black")) {
                isBlackPresent = true;
                break;
            }
        }

        if (isBlackPresent) {
            System.out.println("The dropdown has the option 'Black'");
        } else {
            System.out.println("The dropdown does not have the option 'Black'");
        }

        // Print the first selected option
        WebElement firstSelectedOption = dropdown.getFirstSelectedOption();
        System.out.println("First selected option: " + firstSelectedOption.getText());

        // Select the option "Yellow"
        dropdown.selectByVisibleText("Yellow");
    }
    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
