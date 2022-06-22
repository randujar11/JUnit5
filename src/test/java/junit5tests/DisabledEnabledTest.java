package junit5tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class DisabledEnabledTest {

    @Test
    @Disabled(value = "Disabled for demo of @Disabled")
    void firstTests(){
        System.out.println("This is the first test method");
    }

    @Test
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Disabled for demo of @DisabledOnOS ")
    void secondTests(){
        System.out.println("This is the second test method");
    }

    @Test
    @DisabledIfSystemProperty(named = "env", matches = "staging", disabledReason = "Disabled for demo of @DisabledIfSystemProperty")
    void thirdTests(){
        System.out.println("This is the third test method");
    }

    @Test
    void fourthTests(){
        System.out.println("This is the fourth test method");
    }

    @Test
    void fifthTests(){
        System.out.println("This is the fifth test method");
    }
}
