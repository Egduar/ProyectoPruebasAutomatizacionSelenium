package clase5;

import clase5.refactoring.SpotifyFillingForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SpotifyRegistrationTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/");
        driver.manage().window().maximize();

        //mejor usar el implicitlyWait
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void registrationEmailAlreadyRegistaredTest() {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        wait.until(ExpectedConditions.urlToBe("https://www.spotify.com/uy/signup/"));
        wait.until(ExpectedConditions.titleIs("Registrarte - Spotify"));

        SpotifyFillingForm spotifyFillingForm = new SpotifyFillingForm(driver);
        spotifyFillingForm.fillingFieldsWithConfirmationEmailError();

        wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@aria-label='Indicador de error']")));
        WebElement emailAlreadyRegustrationError = driver.findElement(By.xpath("//*[@aria-label='Indicador de error']"));
        Assert.assertEquals(emailAlreadyRegustrationError.getText(), "Las direcciones de correo electrónico no coinciden.", "Se espearaba un mensaje de error ya que el email debe coincidir");
        Assert.assertTrue(emailAlreadyRegustrationError.getText().contains("Las direcciones de correo electrónico no coinciden."), "Se esperaba otro mensaje de error");

    }

    @Test
    public void registationSuccessTest() {

        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();

        SpotifyFillingForm spotifyFillingForm = new SpotifyFillingForm(driver);
        spotifyFillingForm.filligFields("test@test.com", "test@test.com", "holamundo", "Egduar", "12");

        List<WebElement> errorList = driver.findElements(By.xpath("//*[@aria-label='Indicardor de error']"));
        Assert.assertEquals(errorList.size(),0,"No debería de haber errores");
        Assert.assertTrue(errorList.isEmpty());


    }
}
