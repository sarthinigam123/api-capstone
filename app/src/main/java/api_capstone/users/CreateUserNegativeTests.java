package api_capstone.users;

import api_capstone.users.create.CreateUserRequestBody;
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
       CreateUserRequestBody requestBody = CreateUserRequestBody.builder().firstName("Sarah")
                .lastName("Sharma").email("sarahsharmagmail.com").build();

        //Act
        usersClient.createUser(requestBody)
                .then()
                .log().body()

                //Assert
                .statusCode(400);
    }
}
