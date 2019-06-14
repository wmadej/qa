package com.jsystems.qa.qaapi;

import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

@DisplayName("Api tests")
public class ApiTest {

    @Test
    public void firstApiTest(){
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", Matchers.equalTo("Piotr"))
                .body("surname",Matchers.equalTo("Kowalski"));


    }


    @Test
    public void nestedjasonTest(){
        RestAssured
                .given()
                .get("http://www.mocky.io/v2/5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].imie", Matchers.equalTo("Piotr"))
                .body("[0].nazwisko",Matchers.equalTo("Kowalski"))
        //albo
        .body("imie", notNullValue())
        //.body("[0].device[0].device.model.produce",equalTo("Kowalski"))
        ;
    }
}
