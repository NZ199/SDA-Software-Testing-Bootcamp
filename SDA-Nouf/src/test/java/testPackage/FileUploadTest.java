package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FileUploadTest extends Tests{
    /**
     * Breakout Activity: 20 minute
     * navigate to <a href="https://the-internet.herokuapp.com/upload">Upload Test</a>
     * uploading any file from your machine (make it small please)
     * checking to see that the file was successfully uploaded
     */
    @Test
    public void uploadFile(){
        driver.get("https://the-internet.herokuapp.com/upload");

        By fileUploadInput = By.xpath("(//input[@type='file'])[1]");
        driver.findElement(fileUploadInput).sendKeys("C:/Users/noufz/Pictures/carlogo.jpg");

        driver.findElement(fileUploadInput).submit();

        By uploadSuccessfullyLabel = By.tagName("h3");
        Assertions.assertEquals("File Uploaded!", driver.findElement(uploadSuccessfullyLabel).getText());
    }
}
