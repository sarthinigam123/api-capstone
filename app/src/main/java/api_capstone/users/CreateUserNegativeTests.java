package api_capstone.users;

import api_capstone.users.create.CreateUserRequestBody;
import api_capstone.users.create.response.CreateUserErrorResponse;
import api_capstone.users.create.response.CreateUserResponse;
import io.restassured.http.ContentType;
import org.testng.Assert;
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
        String email = "sarahsharmagmail.com";
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder().firstName("Sarah")
                .lastName("Sharma").email(email).build();

        //Act
        CreateUserErrorResponse errorResponse = usersClient.createUserExpectingError(requestBody);

                //Assert
        Assert.assertEquals(errorResponse.getStatusCode(),400);

        errorResponse.assertResponse(email);
    }
}
