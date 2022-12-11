package junit;

import org.junit.jupiter.api.*;

public class JunitAnnotations {

//    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://hotel-testlab.coderslab.pl//en/");
//    }

    @BeforeAll
    public static void classSetUp() {
        System.out.println("classSetUp()");
    }

    @AfterAll
    public static void classTearDown() {
        System.out.println("classTearDown()");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("setUp()");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tearDown()");
    }

    @Test
    public void testA() {
        System.out.println("testA");
    }

    @Test
    public void testB() {
        System.out.println("testB");
    }

    @Disabled("Wylaczony z jakiegos powodu")
    @Test
    public void testC() {
        System.out.println("testC");
        throw new ArithmeticException();
    }

    @Test
    public void testAssertionA() {
        System.out.println("testAssertionA()");

        int odczytaneZeStrony = 2;
        Assertions.assertEquals(2, odczytaneZeStrony, "Liczby sie nie zgadzaja!");

        String odczytanyKomunikatZeStrony = "Uzytkownik utworzony";
        Assertions.assertTrue(odczytanyKomunikatZeStrony.contains("Uzytkownik utworzony"));

        Assertions.fail();
    }
}
