package api_capstone.users;

import api_capstone.users.create.CreateUserRequestBody;
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

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().firstName("Sarah")
                .lastName("Sharma").email(email).build();

        //Act
        usersClient.createUser(requestBody)
                .then()
                .log().body()

        //Assert
                .statusCode(200);
    }


}
