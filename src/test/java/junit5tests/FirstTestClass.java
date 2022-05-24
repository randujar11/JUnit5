package junit5tests;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTestClass {

    @BeforeAll
    void beforeAll(){
        System.out.println("--This is the before All method");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("----This is the before Each method");
    }

    @AfterAll
    void afterAll(){
        System.out.println("--This is the after All method");
    }

    @AfterEach
    void afterEach(){
        System.out.println("----This is the after Each method");
    }

    @Test
    void firstMethod(){
        System.out.println("This is the first test method");

    }

    @Test
    @DisplayName("Prueba  numero 2")
    public void secondMethod(){
        System.out.println("This is the second test method");


    }

}
