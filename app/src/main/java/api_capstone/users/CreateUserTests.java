package api_capstone.users;

import api_capstone.users.create.CreateUserRequestBody;
import api_capstone.users.create.response.CreateUserResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
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
        CreateUserResponse createUserResponse = usersClient.createUser(requestBody);


        //Assert
        Assert.assertEquals(createUserResponse.getStatusCode(),200);

    }


}
