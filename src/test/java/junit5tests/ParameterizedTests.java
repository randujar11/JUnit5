package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.*;

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
        if (theParam != null && !theParam.equals("")) {
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

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String(String param1){
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringAsString")
    void methodSource_StringStream(String param1){
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    void methodSource_StringDoubleList(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }


    List<String> sourceString() {
        return Arrays.asList("Tomate","Pepino","Lolito");
    }

    Stream<String> sourceStringAsString() {
        return Stream.of("beetroot", "apple", "pear");
    }

    List<Arguments> sourceList_StringDouble() {
        return Arrays.asList(arguments("Tomate", 2.0),
                            arguments("Pepino",8.5),
                            arguments("Lechuga", 7.8));
    }
}
