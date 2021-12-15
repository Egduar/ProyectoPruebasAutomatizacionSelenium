package clase7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TelefonicaTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.telefonica.com/es/web/shareholders-investors");
        driver.manage().window().maximize();
    }

    @Test
    public void telefonicaTest() throws InterruptedException {

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        //
        Thread.sleep(3000);

        driver.switchTo().frame("euroland-ticker-es");
        List<WebElement> tabs = driver.findElements(By.className("Tab"));
        Assert.assertEquals(tabs.size(), 2, "Deberian haber dos Tabs seleccionados");

        for (WebElement tab: tabs) {
            System.out.println("======> " + tab.getText());
            if (tab.getText().equals("NYSE")) {
                tab.click();
            }
        }

        WebElement activeTab = driver.findElement(By.className("Tab_Active"));
        Assert.assertEquals(activeTab.getText(), "NYSE", "La Tab NYSE debería estar seleccionada...");

        Thread.sleep(30000);
        driver.close();

    }


}
