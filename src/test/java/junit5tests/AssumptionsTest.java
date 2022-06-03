package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AssumptionsTest {

    @ParameterizedTest(name = "Run: {index}  -  value: {arguments}")
    @ValueSource(ints = {1,5,6})
    void inValues(int theParam){
        assumeTrue(theParam > 4);
        System.out.println("theParam = " + theParam);

    }

    @ParameterizedTest
    @CsvSource(value = {"Randy,Andujar", "Axel,Andujar", "Mariel,Grullon"})
    void csvSource_StringMethod(String param1, String param2){
        assumeFalse(param1.equals("Mariel"), "The assumption failed for the " +
                "following param2: " + param2);
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
}
