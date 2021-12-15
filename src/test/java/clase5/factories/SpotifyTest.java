package clase5.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SpotifyTest {
    public WebDriver driver;
    private String email;

    public SpotifyTest(String anEmail) {
        this.email = anEmail;
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/");
        driver.manage().window().maximize();
    }

    @Test
    public void landingPageTest() {
        System.out.println("URL ---> " + driver.getCurrentUrl());
        System.out.println("Title ---> " + driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.spotify.com/uy/", "Se esperaba otro URL");
        Assert.assertEquals(driver.getTitle(), "Escuchar es todo - Spotify", "Se esperaba otro Titulo");

        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();

        System.out.println("URL ---> " + driver.getCurrentUrl());
        System.out.println("Title ---> " + driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.spotify.com/uy/signup/", "Se esperaba otro URL");
        Assert.assertEquals(driver.getTitle(), "Registrarte - Spotify", "Se esperaba otro Titulo");

        driver.findElement(By.name("email")).sendKeys(email);
    }
}
