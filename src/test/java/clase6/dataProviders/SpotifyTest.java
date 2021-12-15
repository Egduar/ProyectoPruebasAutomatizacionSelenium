package clase6.dataProviders;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SpotifyTest {

    public WebDriver driver;

    @BeforeMethod
    //public void setup(String GET_ULR_TEST) {
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/");
        driver.manage().window().maximize();
        //driver.get(GET_ULR_TEST);
        //return driver;
    }

    //Es necesario que introduzcas tu correo electrónico.
    // Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com
    @Test(dataProvider = "registro", dataProviderClass = DataProviderGenerator.class)
    public void SpotifyRegistrationTest(String anEmail, String emailRecibido) throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("email")).sendKeys(anEmail);
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        if (emailRecibido.equals("email_vacío")) {
            WebElement errorMsgElement =  driver.findElement(By.xpath("//*[contains(text(), 'Es necesario que introduzcas tu correo electrónico.')]"));
            Assert.assertEquals(errorMsgElement.getText(),"Es necesario que introduzcas tu correo electrónico.", "Se esperaba el error del email vacío...");

        } else if (emailRecibido.equals("email_invalido")) {
            WebElement errorMsgElement =  driver.findElement(By.xpath("//*[contains(text(), 'Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com')]"));
            Assert.assertEquals(errorMsgElement.getText(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com", "Se esperaba el error del email invalido...");
            Assert.assertTrue(errorMsgElement.getText().contains("Asegúrate de que tenga un formato como este"));
        } else if (emailRecibido.equals("email_correcto")) {
            List<WebElement> listaErrores = driver.findElements(By.xpath("//*[@aria-label='Indicador de error']"));
            Assert.assertEquals(listaErrores.size(), 8, "Se esperaba tener 8 errores");
        }

    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
    }
}
