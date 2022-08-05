package api_capstone.users;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUsersTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void shouldGetAllUsers(){
        usersClient.getAllUsers()
                .then()
                .statusCode(200)
                .log().body();
    }



}
