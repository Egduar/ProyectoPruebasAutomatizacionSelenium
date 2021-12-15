package clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.channels.SelectableChannel;
import java.util.List;

import static java.lang.Thread.*;

public class FacebookTest {

    private WebDriver getUrlTestDriver(String GET_ULR_TEST) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("https://www.facebook.com/");
        driver.get(GET_ULR_TEST);
        return driver;
    }

    @Test
    public void facebookLinkTest() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://www.facebook.com/");

        WebDriver driver = getUrlTestDriver("https://www.facebook.com/");

        driver.findElement(By.linkText("¿Olvidaste tu contraseña?")).click();

        Assert.assertEquals(driver.getTitle(), "¿Olvidaste tu contraseña? | No puedo iniciar sesión | Facebook");

        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void facebookPartialLinkTest() throws InterruptedException {
        WebDriver driver = getUrlTestDriver("https://www.facebook.com/");

        driver.findElement(By.partialLinkText("¿Olvidaste")).click();

        //Assert.assertEquals(driver.getTitle(), "¿Olvidaste tu contraseña? |");

        System.out.println("Se ha clickeado Olvidaste tu contraseña....");

        System.out.println("Titulo --> " + driver.getTitle());
        System.out.println("URL --> " + driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(), "¿Olvidaste tu contraseña? | No puedo iniciar sesión | Facebook");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0");

        sleep(5000);
        driver.close();
    }

    @Test
    public void customSalesforceLink() {
        WebDriver driver = getUrlTestDriver("https://login.salesforce.com/");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Use Custom Domain")).click();

        driver.findElement(By.name("mydomain")).sendKeys("as");

        driver.findElement(By.id("mydomainContinue")).click();

        driver.findElement(By.name("username")).sendKeys("test@test.com");

    }

    @Test
    public void checkBoxAndComboboxTest() throws InterruptedException {
        WebDriver driver = getUrlTestDriver("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("firstname")).sendKeys("Antonietta");
        driver.findElement(By.name("lastname")).sendKeys("Descalzo");
        driver.findElement(By.name("reg_email__")).sendKeys("softest.maria.flores@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("softest.maria.flores@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("holamundo");

        WebElement dias = driver.findElement(By.id("day"));
        Select comboboxdía = new Select(dias);
        comboboxdía.selectByValue("4");

        WebElement mes = driver.findElement(By.id("month"));
        Select comboboxMeses = new Select(mes);
        comboboxMeses.selectByVisibleText("abr");

        WebElement ano = driver.findElement(By.id("year"));
        Select comboboxano = new Select(ano);
        comboboxano.selectByValue("2012");

        List<WebElement> ListaSexos = driver.findElements(By.name("sex"));

        WebElement sexMaleElement = ListaSexos.get(1);
        sexMaleElement.click();
    }

    @Test
    public void birthdateTest() throws InterruptedException {
        WebDriver driver = getUrlTestDriver("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("firstname")).sendKeys("Antonietta");
        driver.findElement(By.name("lastname")).sendKeys("Descalzo");
        driver.findElement(By.name("reg_email__")).sendKeys("softest.maria.flores@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("softest.maria.flores@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("holamundo");

        WebElement dias = driver.findElement(By.id("day"));
        Select comboboxdía = new Select(dias);
        comboboxdía.selectByValue("20");

        WebElement mes = driver.findElement(By.id("month"));
        Select comboboxMeses = new Select(mes);
        comboboxMeses.selectByVisibleText("dic");

        WebElement ano = driver.findElement(By.id("year"));
        Select comboboxano = new Select(ano);
        comboboxano.selectByValue("1990");

    }

    @Test
    public void comboboxTest() throws InterruptedException {
        WebDriver driver = getUrlTestDriver("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("firstname")).sendKeys("Antonietta");
        driver.findElement(By.name("lastname")).sendKeys("Descalzo");
        driver.findElement(By.name("reg_email__")).sendKeys("softest.maria.flores@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("softest.maria.flores@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("holamundo");

        WebElement dias = driver.findElement(By.id("day"));
        Select comboboxdía = new Select(dias);
        comboboxdía.selectByValue("15");

        WebElement mes = driver.findElement(By.id("month"));
        Select comboboxMeses = new Select(mes);
        comboboxMeses.selectByVisibleText("mar");

        WebElement ano = driver.findElement(By.id("year"));
        Select comboboxano = new Select(ano);
        comboboxano.selectByValue("1990");

        WebElement meses = driver.findElement(By.name("birthday_month"));
        Select comboboMeses = new Select(meses);

        List<WebElement> Opciones = comboboMeses.getOptions();
        Assert.assertNotEquals(0, Opciones.size());

        boolean validar = false;

        for (WebElement opt : Opciones) {
            System.out.println(opt.getText());
            if (opt.getText().contentEquals("ene") ||
                    opt.getText().contentEquals("feb") ||
                        opt.getText().contentEquals("mar")) {
                validar = true;
                break;
            }
            Assert.assertTrue(validar);
        }
    }

    @Test
    public void completeRegistration() throws InterruptedException {
        WebDriver driver = getUrlTestDriver("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(2000);

        driver.findElement(By.name("firstname")).sendKeys("Antonietta");
        driver.findElement(By.name("lastname")).sendKeys("Descalzo");
        driver.findElement(By.name("reg_email__")).sendKeys("softest.maria.flores@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("softest.maria.flores@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("holamundo");

        setBirthdate(driver, "22", "jun", "1990");

    }

    @Test
    private void setBirthdate (WebDriver driver, String day, String month, String year) {

        WebElement dias = driver.findElement(By.name("birthday_day"));
        Select combodía = new Select(dias);
        combodía.selectByVisibleText(day);

        WebElement meses = driver.findElement(By.name("birthday_month"));
        Select comboMeses = new Select(meses);
        comboMeses.selectByVisibleText(month);

        WebElement ano = driver.findElement(By.name("birthday_year"));
        Select comboano = new Select(ano);
        comboano.selectByVisibleText(year);
    }
}
