package testPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");

        String expectedUrl = "https://www.facebook.com/";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)) {
            System.out.println("Expected URL matches the actual URL.");
        } else {
            System.out.println("Expected URL does not match the actual URL !!.");
        }

        // Verify pagesource contains "Facebook"
        String pageSource = driver.getPageSource();
        if (pageSource.contains("Facebook")) {
            System.out.println("Page source of Facebook contains 'Facebook'.");
        } else {
            System.out.println("Page source of Facebook does not contain 'Facebook'!!.");
        }

        // Close the browser
        driver.quit();
    }
}
