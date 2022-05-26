package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {

    @ParameterizedTest(name = "Run: {index}  -  value: {arguments}")
    @ValueSource(ints = {1,5,6})
    void inValues(int theParam){
        System.out.println("theParam = " + theParam);

    }
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"firstString" , "secondString"})
    void stringValue(String theParam){
        if (theParam != null && theParam != "") {
            System.out.println("thePar = " + theParam);
        } else System.out.println("Test fallido");

    }

    @ParameterizedTest
    @ValueSource(ints = {1,5,6})
    void validation(int param){
        if (param == 1) {
            System.out.println("Test Correcto");
        } else {
            System.out.println("Test fallido");
        }
    }

    //CSV Method
    @ParameterizedTest
    @CsvSource(value = {"Randy,Andujar", "Axel,Andujar", "Mariel,Grullon"})
    void csvSource_StringMethod(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"Randy,29,true","Axel,1,false","Mariel,25,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"Randy-Andujar", "Axel-Andujar"}, delimiter = '-')
    void csvSource_StringWithDiffDelimiter(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppinglist.csv", numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntString(String name, double price, int qty, String provider){

        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", provider = " + provider);

    }
}
