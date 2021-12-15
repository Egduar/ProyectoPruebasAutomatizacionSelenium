package clase6.dataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEjemplo1 {

    @DataProvider (name="personas")
    public Object[][] datosDePersonas() {
        return new Object[][] {
                {"Juan", 25},
                {"Maria", 32}
        };
    }

    @Test (dataProvider = "personas")
    public void mostrarInformacionTest(String unNombre, int unaEdad) {
        System.out.println(unNombre + " tiene una edad de " + unaEdad);
    }

}
