package api_capstone.users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUserTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void shouldCreateUser(){
        //Arrange

        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String body = String.format("{\n" +
                "    \"firstName\" : \"Sarah\",\n" +
                "    \"lastName\" : \"Sharma\",\n" +
                "    \"email\" : \"%s\"\n" +
                "}",email);

        //Act
        usersClient.createUser(body)
                .then()
                .log().body()

        //Assert
                .statusCode(200);
    }


}
