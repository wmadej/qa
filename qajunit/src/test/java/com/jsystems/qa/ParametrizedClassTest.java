package com.jsystems.qa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Parametrized tests")
public class ParametrizedClassTest {
    @DisplayName("First pamaetrized test")
    @ParameterizedTest(name = "Parametrized test with value {0}")
    @ValueSource(ints = {5,15,25})
    public void paramFirstTest(int number){
        assertTrue(number % 5 ==0);
    }

    @DisplayName("Second pamaetrized test")
    @ParameterizedTest(name = "Parametrized test with value {0}")
    @ValueSource(strings = {"Hello","Help","Unit","Hello student"})

    public void paramSecondTest(String value){
        assertTrue(value.contains("Hello"));


    }

}
