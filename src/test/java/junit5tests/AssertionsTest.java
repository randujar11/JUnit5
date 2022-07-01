package junit5tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionsTest {

    @Test
    void assertEqualsTest(){
        assertEquals("firstString", "firstString", "The string " +
                "values were not equal");
    }

    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = Arrays.asList("firstString","secondString", "thirdString");
        List<String> actualdValues = Arrays.asList("firstString","secondString", "thirdString");

        assertEquals(expectedValues,actualdValues);
    }

    @Test
    void asserArraysEqualTest() {
        int[] expectedValues = {1,2,3,4};
        int[] actualValues = {1,2,3,4};

        assertArrayEquals(expectedValues,actualValues, "The values is not equals");

    }


}
