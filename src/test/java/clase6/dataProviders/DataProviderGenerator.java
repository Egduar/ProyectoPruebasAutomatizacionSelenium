package clase6.dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviderGenerator {

    @DataProvider(name="paises")
    public Object[][] datosPaises() {
        return new Object[][] {
                {"Santiago", "Chile"},
                {"Buenos Aires", "Argentina"},
                {"Montevideo", "Uruguay"}
        };
    }

    @DataProvider(name="login")
    public Object[][] datosDeLogin() {
        return new Object[][] {
                {"testing@test.com", "holamundo"},
                {"qe@qa.com", "qaselenium111"},
                {"test@test.com", "qaunitedselenium"}
        };
    }

    @DataProvider(name="registro")
    public Object[][] emailsDeRegistro() {
        return new Object[][] {
                {"", "email_vacío"},
                {"qaselenium","email_invalido"},
                {"selenium12mayo@gmail.com","email_correcto"}
        };
    }


}
