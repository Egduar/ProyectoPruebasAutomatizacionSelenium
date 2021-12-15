package clase5.refactoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpotifyFillingForm {
    public WebDriver driver;

    public SpotifyFillingForm(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public void fillingFieldsWithConfirmationEmailError() {

        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.id("confirm")).sendKeys("test@test,com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("holamundo");
        driver.findElement(By.id("displayname")).sendKeys("RegistrationTest");
        driver.findElement(By.id("day")).sendKeys("22");
    }

    public void fillingFieldsSuccessfully() {
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.id("confirm")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("holamundo");
        driver.findElement(By.id("displayname")).sendKeys("RegistrationTest");
        driver.findElement(By.id("day")).sendKeys("22");
    }

    public void filligFields(String anEmail, String aConfirmationEmail, String aPassword, String aDisplayName, String aDay) {
        driver.findElement(By.name("email")).sendKeys(anEmail);
        driver.findElement(By.id("confirm")).sendKeys(aConfirmationEmail);
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys(aPassword);
        driver.findElement(By.id("displayname")).sendKeys(aDisplayName);
        driver.findElement(By.id("day")).sendKeys(aDay);

    }
}
