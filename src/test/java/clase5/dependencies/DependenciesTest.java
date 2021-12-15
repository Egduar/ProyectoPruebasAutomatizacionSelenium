package clase5.dependencies;

import clase5.refactoring.SpotifyFillingForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DependenciesTest {
    public WebDriver driver;

    @BeforeTest
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
    }

    @Test (dependsOnMethods = {"landingPageTest"})
    public void fillingFieldsTest() {
        SpotifyFillingForm spotifyFillingForm = new SpotifyFillingForm(driver);
        spotifyFillingForm.fillingFieldsWithConfirmationEmailError();

        WebElement emailAlreadyRegustrationError = driver.findElement(By.xpath("//*[@aria-label='Indicador de error']"));
        Assert.assertEquals(emailAlreadyRegustrationError.getText(), "Las direcciones de correo electrónico no coinciden.", "Se espearaba un mensaje de error ya que el email debe coincidir");
        Assert.assertTrue(emailAlreadyRegustrationError.getText().contains("Las direcciones de correo electrónico no coinciden."), "Se esperaba otro mensaje de error");

    }

}
