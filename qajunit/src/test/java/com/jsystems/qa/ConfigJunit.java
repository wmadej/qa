package com.jsystems.qa;


import org.junit.AfterClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;

public class ConfigJunit {

    @BeforeAll
    public static void setUpAll(TestInfo testInfo){
        System.out.println("====================BeforeAll================");
        System.out.println("====================Test name class name: " + testInfo.getTestClass()
        + "\ntest name: " + testInfo.getTestMethod());
    }
    @AfterClass
    public static void tearDownAll(){
        System.out.println("====================AfterAll================");

    }


}
