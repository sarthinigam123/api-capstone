package api_capstone.users;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserNegativeTests {
    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("app-id","62ec44a25c53f4761649efac")
                .body("{\n" +
                        "    \"lastName\" : \"Sharma\",\n" +
                        "    \"firstName\" : \"Sarah\",\n" +
                        "    \"email\" : \"sarahsharmagmail.com\"\n" +
                        "}")
                .when()
                .post("https://dummyapi.io/data/v1/user/create")
                .then()
                .log().body()
                .statusCode(400);
    }
}
