package clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SpotifyWithCssSelectorTest {
    private WebDriver getUrlTestDriver(String GET_ULR_TEST) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("https://www.facebook.com/");
        driver.get(GET_ULR_TEST);
        return driver;
    }

    @Test
    public void spotifyByPlaceHolderTest() throws InterruptedException {
        WebDriver driver = getUrlTestDriver("https://www.spotify.com/uy/signup/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("holamundo");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("Egduar22");

        driver.findElement(By.cssSelector("input[placeholder='DD']")).sendKeys("22");
        WebElement mes = driver.findElement(By.id("month"));
        Select comboboxMeses = new Select(mes);
        comboboxMeses.selectByVisibleText("Julio");
        driver.findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys("1975");

        driver.findElement(By.xpath("//*[@for='gender_option_male']/span")).click();
        driver.findElement(By.xpath("//*[@for='marketing-opt-checkbox']/span")).click();
        driver.findElement(By.xpath("//*[@for='third-party-checkbox']/span")).click();

    }

}
