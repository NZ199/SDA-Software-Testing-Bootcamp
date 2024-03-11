package testPackage;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Test;

/**
 * navigate to this url https://www.saucedemo.com/v1/inventory.html
 * add the first item you find to your cart
 * open your cart*
 * assert that the item name is correct inside the cart
 */

public class saucedemoTest {
    WebDriver driver;


    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/inventory.html");
    }
    @Test
    public void addItemToCart() {
        By addFirstItemToCartButton = By.xpath("(//button[contains(@class,'btn_inventory')])[1]");
        driver.findElement(addFirstItemToCartButton).click();

        By opencartButton = By.xpath("//a[contains(@class,'shopping_cart_link')]");
        driver.findElement(opencartButton).click();

        By firstCartItemNameLabel = By.xpath("//div[@class='inventory_item_name']");
        var actualFirstItemName = driver.findElement(firstCartItemNameLabel).getText();
        Assertions.assertEquals("Sauce Labs Backpack", actualFirstItemName);
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

}
