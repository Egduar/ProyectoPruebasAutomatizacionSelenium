package clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Pactico1Ejercicio14 {

    @Test
    public void NetflixPageTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/uy/");

        List<WebElement> ListaH1s = driver.findElements(By.tagName("h1"));
        System.out.println("La cantidad de H1s en el sitio son " + ListaH1s.size());
        System.out.println("---> Elementos H1 <---");
        for (WebElement elementoH1s: ListaH1s) {
            System.out.println(elementoH1s.getText());
        }
        System.out.println("*******************");

        List<WebElement> ListaH2s = driver.findElements(By.tagName("h2"));
        System.out.println("La cantidad de H2s en el sitio son " + ListaH2s.size());
        System.out.println("---> Elementos H2 <---");
        for (WebElement elementoH2s: ListaH2s) {
            System.out.println(elementoH2s.getText());
        }
        System.out.println("*******************");

        driver.navigate().refresh(); // refrescar

        List<WebElement> ListaBotones = driver.findElements(By.tagName("button"));

        System.out.println("---> Botone Netflix<---");
        for (WebElement boton: ListaBotones) {
            System.out.println(boton.getText());
        }

        List<WebElement> ListaDiv = driver.findElements(By.tagName("div"));
        System.out.println("");
        System.out.println("La cantidad de Elementos div en el sitio son " + ListaDiv.size());

        System.out.println("");
        System.out.println("Titulo de la página: " + driver.getTitle());

        System.out.println("");
        List<WebElement> ListaLink = driver.findElements(By.tagName("link"));
        System.out.println("La cantidad de Elementos div en el sitio son " + ListaLink.size());

    }
}
