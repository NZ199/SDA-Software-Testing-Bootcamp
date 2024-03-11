package testPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Assert that the login is successful
        WebElement inventoryContainer = driver.findElement(By.className("inventory_container"));
        if (inventoryContainer.isDisplayed()) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }


        // Close the browser
        driver.quit();
    }
}
