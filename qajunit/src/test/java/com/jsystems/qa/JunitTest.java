package com.jsystems.qa;


import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("JunitTest")
public class JunitTest {
    final String stringTestowy = "stringTestowy";
    final String testowy = null;

    @Test
    @DisplayName("First test")
    @Disabled("First test")
    public void firstTest() {
        assertTrue(true, "message for test result");
        assertFalse(false);
        assertTrue(true);
        assertEquals("stringTestowy", stringTestowy);
//        assertNotNull(testowy);
        assertSame("stringTestowy",stringTestowy);
        assertFalse(stringTestowy.matches("^s"));


    }
    @Test
    @DisplayName("Second test")
    @Tag("2")
    //powtórzyc test w petli
    @RepeatedTest(2)
    public void secondTest() {
        assertThat(stringTestowy).isEqualTo("stringTestowy");
        //assertTrue(0.2 * 0.2 == 0.04);
        System.out.println(0.2 * 0.2);
        assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.04);

    }

    @Test
    @DisplayName("Array test")
    public void arrayTest() {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer>list2 = Arrays.asList(3,4,5);
        assertTrue(list1.containsAll(list2));
        assertThat(list1).hasSize(5);


    }
    @Nested public class NestedSuiteClassTest {

        final String stringTestowy = "stringTestowy";

        @Test
        @DisplayName("nested class test")
        public void nesteedTest() {
            assertEquals("stringTestowy", stringTestowy);
        }


    }
}
