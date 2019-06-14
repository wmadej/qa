package com.jsystems.qa.qaapi;

import com.jsystems.qa.qaapi.database.UserDao;
import com.jsystems.qa.qaapi.model.MyUser;
import com.jsystems.qa.qaapi.model.User;
import com.jsystems.qa.qaapi.model.UserDb;
import com.jsystems.qa.qaapi.model.error.ErrorResponse;
import com.jsystems.qa.qaapi.service.ApiService;
import difflib.myers.MyersDiff;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
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
    @Test
    @DisplayName("First test with mapping to jasonPath")
    public void jasonPathTest(){
        List<User> users = ApiService.getUsers();
        assertThat(users.get(0).imie).isEqualTo("Piotr");
        assertThat(users.get(0).nazwisko).isEqualTo("Kowalski");
        assertThat(users.get(0).device.get(0).type).isEqualTo("computer");
        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce).isEqualTo("dell");
        assertThat(users.get(0).device.get(0).deviceModel.get(0).screenSize).isEqualTo(17);
    }


    @Test
    @DisplayName("Test with mapped MyUser")
    public void myUserJsonPath(){
        MyUser myUser = ApiService.getUser();
        assertThat(myUser.name).isEqualTo("Piotr");
        assertThat(myUser.surname).isEqualTo("Kowalski");

    }


    @Test
    @DisplayName("Post test")
    public void postTest(){
        String[] strings = ApiService.postMyUser(new MyUser("Piotr","Kowalski"));
        assertThat(strings).isEmpty();
    }

    @Test
    @DisplayName("Error response")
    public void erroResponse() {
        ErrorResponse errorResponse = ApiService.getErrorResponse();
        assertThat(errorResponse.error.errorCode).isEqualTo("invalid_email");
        assertThat(errorResponse.error.message).isEqualTo("your email is invalid");


    }
    @Test
    public void dbTest(){
        UserDb userDb = UserDao.getoneById(1L);
        assertThat(userDb.getName()).isEqualTo("Piotr");


    }


}
