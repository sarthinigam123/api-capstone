package api_capstone.users;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
    @Test
    public void shouldCreateUser(){

        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("app-id","62ec44a25c53f4761649efac")
                .body("{\n" +
                        "    \"lastName\" : \"Sharma\",\n" +
                        "    \"firstName\" : \"Sarah\",\n" +
                        "    \"email\" : \"sarahsharma@gmail.com\"\n" +
                        "}")
                .when()
                .post("https://dummyapi.io/data/v1/user/create")
                .then()
                .log().body()
                .statusCode(200);
    }
}
