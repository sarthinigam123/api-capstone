package api_capstone.users;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        //Arrange
        String body = "{\n" +
                "    \"firstName\" : \"Sarah\",\n" +
                "    \"lastName\" : \"Sharma\",\n" +
                "    \"email\" : \"sarahsharmagmail.com\"\n" +
                "}";

        //Act
        usersClient.createUser(body)
                .then()
                .log().body()
                //Assert
                .statusCode(400);
    }
}
