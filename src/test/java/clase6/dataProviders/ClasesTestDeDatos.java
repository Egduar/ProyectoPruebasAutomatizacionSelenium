package clase6.dataProviders;

import org.testng.annotations.Test;

public class ClasesTestDeDatos {

    @Test(dataProvider = "paises", dataProviderClass = DataProviderGenerator.class)
    public void mostrarPaises(String unaCapital, String unaPais) {
        System.out.println("la capital de " + unaPais + " es " + unaCapital);
    }
}
