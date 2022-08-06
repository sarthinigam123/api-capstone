package api_capstone.users;

import api_capstone.users.create.User;
import api_capstone.users.create.response.CreateUserErrorResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserNegativeTests {

    private UsersClient usersClient;

    @BeforeClass(groups={"users"})
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test(groups={"users"})
    public void shouldNotAllowToCreateUserWithInvalidEmail(){
        //Arrange
        String email = "sarahsharmagmail.com";
        User requestBody = User.builder().firstName("Sarah")
                .lastName("Sharma").email(email).build();

        //Act
        CreateUserErrorResponse errorResponse = usersClient.createUserExpectingError(requestBody);

                //Assert
        Assert.assertEquals(errorResponse.getStatusCode(),400);

        errorResponse.assertResponse(email);
    }
}
