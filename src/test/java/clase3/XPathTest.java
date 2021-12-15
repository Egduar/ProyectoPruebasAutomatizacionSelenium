package clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class XPathTest {

    private WebDriver getUrlTestDriver(String GET_ULR_TEST) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("https://www.facebook.com/");
        driver.get(GET_ULR_TEST);
        return driver;
    }

    @Test
    public void netflixLinkTest() throws InterruptedException {
        WebDriver driver = getUrlTestDriver("https://www.netflix.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"appMountPoint\"]/div/div/div/div/div/div[1]/div/a")).click(); // Copy Xpath
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[1]/div/a")).click(); // Copy full xpath
    }

    @Test
    public void xpathByPlaceHolder() throws InterruptedException {
        WebDriver driver = getUrlTestDriver("https://www.spotify.com/uy/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.xpath("//*[@placeholder='Introduce tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@placeholder='Crea una contraseña.']")).sendKeys("holamundo");
    }

    @Test
    public void cssSelectorPlaceHolder() throws InterruptedException {
        WebDriver driver = getUrlTestDriver("https://www.spotify.com/uy/");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("test@test.com");

        //driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        //driver.findElement(By.xpath("//*[@placeholder='Introduce tu correo electrónico.']")).sendKeys("test@test.com");
        //driver.findElement(By.xpath("//*[@placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("test@test.com");
        //driver.findElement(By.xpath("//*[@placeholder='Crea una contraseña.']")).sendKeys("holamundo");
    }

    @Test
    public void completeDocusignRegistrationForm() throws InterruptedException {
        WebDriver driver = getUrlTestDriver("https://go.docusign.com/o/trial/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Egduar");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Torrealba");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("selenium@test.com");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("+584122492824");
        driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Panadero");

        Select dsIndustry = new Select(driver.findElement(By.name("ds_industry")));
        dsIndustry.selectByValue("Financial Services");
    }

    @Test
    public void defaultxPath() throws InterruptedException {
        WebDriver driver = getUrlTestDriver("https://go.docusign.com/o/trial/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id='dsFormLabel_First_Name']/input")).sendKeys("Egduar");
        driver.findElement(By.xpath("//*[@id='dsFormLabel_Last_Name']/input")).sendKeys("Torrealba");
        driver.findElement(By.xpath("//*[@id='dsFormLabel_Email']/input")).sendKeys("selenium@test.com");
        driver.findElement(By.xpath("//*[@id='dsFormLabel_Phone']/input")).sendKeys("+584122492824");
        driver.findElement(By.xpath("//*[@id='dsFormLabel_Job_Title']/input")).sendKeys("Panadero");

        Select dsIndustry = new Select(driver.findElement(By.xpath("//*[@id='dsFormLabel_Industry']/select")));
        dsIndustry.selectByValue("Financial Services");
    }

    @Test
    public void spotifyByNameTest() throws InterruptedException {
        WebDriver driver = getUrlTestDriver("https://www.spotify.com/uy/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("test@test.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("holamundo");
        driver.findElement(By.xpath("//input[@name='displayname']")).sendKeys("Egduar22");

        driver.findElement(By.xpath("//input[@name='day']")).sendKeys("22");
        WebElement mes = driver.findElement(By.id("month"));
        Select comboboxMeses = new Select(mes);
        comboboxMeses.selectByVisibleText("Julio");
        driver.findElement(By.xpath("//input[@name='year']")).sendKeys("1965");

        driver.findElement(By.xpath("//*[@for='gender_option_male']/span")).click();
        driver.findElement(By.xpath("//*[@for='marketing-opt-checkbox']/span")).click();
        driver.findElement(By.xpath("//*[@for='third-party-checkbox']/span")).click();

        //driver.findElement(By.xpath("//*[@placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("test@test.com");
        //driver.findElement(By.xpath("//*[@placeholder='Crea una contraseña.']")).sendKeys("holamundo");


    }


}
