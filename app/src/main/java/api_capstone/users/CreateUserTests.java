package api_capstone.users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTests {
    @Test
    public void shouldCreateUser(){
        //Arrange
        String body = "{\n" +
                "    \"firstName\" : \"Sarah\",\n" +
                "    \"lastName\" : \"Sharma\",\n" +
                "    \"email\" : \"sarahsharma12@gmail.com\"\n" +
                "}";

        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
        //Assert
                .statusCode(200);
    }


}
