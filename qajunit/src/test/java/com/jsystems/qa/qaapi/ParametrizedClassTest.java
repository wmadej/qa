package com.jsystems.qa.qaapi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;





@DisplayName("Parametrized tests")
public class ParametrizedClassTest extends ConfigJunit{


    @BeforeEach
    public void setUp(){
        System.out.println("====================BeforeEach================");
    }
    @AfterEach
    public void tearDown(){
        System.out.println("====================AfterEach================");
    }



    @DisplayName("First pamaetrized test")
    @ParameterizedTest(name = "Parametrized test with value {0}")
    @ValueSource(ints = {5,15,25})
    public void paramFirstTest(int number){
        assertTrue(number % 5 ==0);
    }

    @DisplayName("Second pamaetrized test")
    @ParameterizedTest(name = "Parametrized test with value {0}")
    @ValueSource(strings = {"Hello","Hello Help","Hello Unit","Hello student"})

    public void paramSecondTest(String value){
        assertTrue(value.contains("Hello"));


    }
    @DisplayName("CSV value parametrized test")
    @ParameterizedTest(name = "Parametrized test with values name {0} and value {1}")
    @CsvSource(value =  {"Hello, 5", "HelloJunit 5, 15", "'Hello 5!', 25"}, delimiter = ',')
    public void paramMultiArgTest(String param1, int param2)
    {
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5 == 0);
    }

    @DisplayName("CSV file source parametrized test")
    @ParameterizedTest(name= "Parametrized test with data from csv file, name {0} and value {1}")
    @CsvFileSource(resources = "/plik.csv",delimiter = ',')
    public void csvFileSourceTest(String param1, int param2){
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5 == 0);
    }





}
