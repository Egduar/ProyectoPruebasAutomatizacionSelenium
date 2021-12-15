package clase4;

import org.testng.annotations.*;

public class NototionsTest {

    @BeforeTest
    public void beforeTestNotation() {
        System.out.println("Se invoca @BeforeTest");
    }

    @BeforeClass
    public void beforeClassNotation() {
        System.out.println("Se invoca @BeforeClass");
    }

    @BeforeMethod
    public void beforeMethodNotation() {
        System.out.println("Se invoca @BeforeMethod");
    }


    @Test (priority = 2, groups = "successTest")
    public void test1() {
        System.out.println("Se ejecuta el Test 1!!!");
    }

    @Test (priority = 1, groups = "successTest")
    public void test2() {
        System.out.println("Se ejecuta el Test 2!!!");
    }

    @Test (priority = 0, groups = "failureTest")
    public void test3() {
        System.out.println("Se ejecuta el Test 3!!!");
    }

    @AfterMethod
    public void afterMethodNotation() {
        System.out.println("Se invoca @AfterMethod");
    }

    @AfterClass
    public void afterClassNotation() {
        System.out.println("Se invoca @AfterClass");
    }

    @AfterTest
    public void afterTestNotation() {
        System.out.println("Se invoca @AfterTest");
    }

}
