package api_capstone.users;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserNegativeTests {
    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        //Arrange
        String body = "{\n" +
                "    \"firstName\" : \"Sarah\",\n" +
                "    \"lastName\" : \"Sharma\",\n" +
                "    \"email\" : \"sarahsharmagmail.com\"\n" +
                "}";

        //Act
        new UsersClient().createUser(body)
                .then()
                .log().body()
                //Assert
                .statusCode(400);
    }
}
