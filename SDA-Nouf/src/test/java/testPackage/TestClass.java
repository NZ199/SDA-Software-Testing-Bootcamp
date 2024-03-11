package testPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

    @Test
    public void testMethod(){
        // we will follow the official user guide
        // https://www.selenium.dev/documentation/webdriver/getting_started/first_script/

        // 1. Start the session
        // Selenium Manager will download the driver for you, and it will also download the entire browser if you don't have it installed on your machine.
        // It will download it to a temporary directory, to be used in isolation, and only for your selenium tests.
        WebDriver driver = new ChromeDriver();

        // 2. Take action on browser
        //you can either use driver.get or driver.navigate.to to navigate to any url
//        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");

        // 3. Request browser information
        var title = driver.getTitle();
        driver.quit();
    }
}