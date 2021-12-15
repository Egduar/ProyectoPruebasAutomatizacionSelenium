package clase1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class EjerciciosSelenium {

    @Test
    public void testInWindows() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://es-la.facebook.com/");

        System.out.println("Titulo de la página " + driver.getTitle());
        System.out.println("URL de la página " + driver.getCurrentUrl());
    }

    @Test
    public void bbcMundoTest() {
        String ULR_BBC_MUNDO = "https://www.bbc.com/mundo";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(ULR_BBC_MUNDO);

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


        List<WebElement> ListaLinks = driver.findElements(By.tagName("a"));
        System.out.println("La cantidad de Links en el sitio son " + ListaLinks.size());
        int contadorLinkSinTexto = 0;

        for (WebElement Link: ListaLinks) {
            if (Link.getText().isEmpty() == false ) { // Muestros los Link que tengan texto
                System.out.println("Link ---> " + Link.getText());
            } else {
                contadorLinkSinTexto++;
            }
        }
        System.out.println("La cantidad de Links sin Texto son " + contadorLinkSinTexto);
        //driver.close();

        List<WebElement> ListaBotones = driver.findElements(By.tagName("button"));
        System.out.println("La cantidad de Botones en el sitio son " + ListaBotones.size());

    }

    @Test
    public void netflixTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/ve/");

        List<WebElement> ListaBotones = driver.findElements(By.tagName("button"));
        System.out.println("La cantidad de Botones en el sitio son " + ListaBotones.size());

        System.out.println("---> Botone Netflix<---");
        for (WebElement boton: ListaBotones) {
            System.out.println(boton.getText());
        }
        System.out.println("*******************");

        ListaBotones.get(0).click();
        //WebElement cuanoCuestaNetflixBtn = ListaBotones.get(2);
        //cuanoCuestaNetflixBtn.click();

    }

    @Test
    public void bbcMundoListas() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo/");

        List<WebElement> ListaLi = driver.findElements(By.tagName("li"));
        System.out.println("La cantidad de Listas en el sitio son " + ListaLi.size());
        int contadorLiSinTexto = 0;

        System.out.println("---> li BBC MUNDO <---");
        for (WebElement li: ListaLi) {
            if (li.getText().isEmpty() == false ) { // Muestros los Link que tengan texto
                System.out.println(li.getText());
            } else {
                contadorLiSinTexto++;
            }
        }
        System.out.println("La cantidad de Links sin Texto son " + contadorLiSinTexto);
        System.out.println("*******************");

    }

    @Test
    public void spotifyTitleTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/bo/");
        driver.manage().window().maximize();

        //List<WebElement> ListaH1s = driver.findElements(By.tagName("h1"));
        String tituloSpotify;

        System.out.println("---> H1 Spotify <---");
        tituloSpotify = driver.getTitle();
        System.out.println(tituloSpotify);

       if (tituloSpotify.equals("Escuchar es todo - Spotify")) {
          System.out.println("Test Passed!!!");
       } else {
          System.out.println("Test Failed!!!");
       }

    }

    @Test
    public void getWindowsSiteTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        int ancho = driver.manage().window().getSize().width;
        int alto =  driver.manage().window().getSize().height;

        System.out.println("El Ancho es " + ancho);
        System.out.println("El Alto es " + alto);

        Dimension dimension = new Dimension(1024, 768);
        driver.manage().window().setSize(dimension);
        System.out.println("Actualizando el Ancho y el Alto de la página ");

        ancho = driver.manage().window().getSize().width;
        alto =  driver.manage().window().getSize().height;

        System.out.println("El Ancho actualizado es " + ancho);
        System.out.println("El Alto actualizado es " + alto);

        getGoogleDriver();
        getDriver("https://softest.com.ve/");

    }

    @Test
    public void getGoogleDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

    }

    @Test
    public WebDriver getDriver(String URL_GET_DRIVER) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get(URL_GET_DRIVER);
        return driver;
    }

    //Acceder a google.com
    //Ingresar en el buscador, la palabra “WebElement” y presionar enter
    @Test
    public void searchInGoogle() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("WebElement" + Keys.ENTER);
    }

    @Test
    public void searchInGoogleAndGoBack() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println("Titulo de la página: " + driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("WebElement" + Keys.ENTER);
        driver.navigate().back(); //volver atras
        driver.navigate().refresh(); // refrescar
        driver.navigate().forward(); // ir hacia adelante
    }

    @Test
    public void facebookPageTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        List<WebElement> ListaDiv = driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de div en el sitio son " + ListaDiv.size());

        for (WebElement hiperVinculo: ListaDiv) {
            System.out.println(hiperVinculo.getText());
        }

        List<WebElement> ListaBotones = driver.findElements(By.tagName("button"));
        System.out.println("La cantidad de Botones en el sitio son " + ListaBotones.size());

        for (WebElement boton: ListaBotones) {
            System.out.println(boton.getText());
        }
    }

    @Test
    public void sendKeysToFacebook() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.name("pass")).sendKeys("holamundo");

        List<WebElement> ListaBotones = driver.findElements(By.tagName("button"));
        System.out.println("La cantidad de Botones en el sitio son " + ListaBotones.size());

        //ListaBotones.get(0).click();
        for (WebElement boton: ListaBotones) {
           System.out.println(boton.getText());
           if (boton.getText().equals("Iniciar sesión")) {
               boton.click();
            }
        }
    }

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

