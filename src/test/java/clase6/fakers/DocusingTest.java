package clase6.fakers;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DocusingTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://go.docusign.com/o/trial");
        driver.manage().window().maximize();
    }

    @Test
    public void docusing() {

        Faker faker = new Faker();

        driver.findElement(By.name("first_name")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("last_name")).sendKeys(faker.name().lastName());
        driver.findElement(By.name("email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.name("phone")).sendKeys(faker.phoneNumber().phoneNumber());
        driver.findElement(By.name("title")).sendKeys(faker.job().title());


    }
}
