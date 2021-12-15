package clase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class SpotifyWithTestngTest {
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

    @Test
    @Parameters({"username", "password"})
    public void registrationTest(@Optional("test@test.com") String testEmail, @Optional("holapep") String claveEmail) throws InterruptedException {
        //driver = setup("https://www.spotify.com/uy/signup/");

        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        //Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@placeholder='Introduce tu correo electrónico.']")).sendKeys(testEmail);
        driver.findElement(By.xpath("//*[@placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys(testEmail);
        driver.findElement(By.xpath("//*[@placeholder='Crea una contraseña.']")).sendKeys(claveEmail);
    }

    @Test
    @Parameters({"tagname"})
    public void parametersFromTestngXML(@Optional("a") String tagnameParameters) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Se van a imprimir todos los " + tagnameParameters);
        List<WebElement> tagElementList = driver.findElements(By.tagName(tagnameParameters));

        for (WebElement elemento : tagElementList) {
            System.out.println("---> " + elemento.getText());
        }
    }

    @Test
    public void spotifyErrorsTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        List<WebElement> listaErrores = driver.findElements(By.xpath("//*[@aria-label='Indicador de error']"));
        Assert.assertEquals(listaErrores.size(), 9, "Se esperaba tener 9 errores");

        // Listar los mensaje des Error
        boolean errorContraseñaPresente = false;
        for (WebElement element : listaErrores) {
            System.out.println("---> " + element.getText());
            if (element.getText().equals("Debes introducir una contraseña.")) {
                errorContraseñaPresente=true;
            }
        }
        Assert.assertTrue(errorContraseñaPresente, "No se encontro Error en la COntraseña");

        driver.findElement(By.xpath("//*[contains(text(), 'Hombre')]")).click();

        //Buscar un solo mensaje
        WebElement perfilVacioErroresElement = driver.findElement(By.xpath("//*[contains(text(), 'Confirma que no eres un robot.')]"));
        Assert.assertEquals(perfilVacioErroresElement.getText(),"Confirma que no eres un robot.", "El error del perfil vacio debería estar Presente ");
    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }
}
