package api_capstone.users;

import api_capstone.users.getAll.GetAllUsersResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUsersTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test(groups={"users"})
    public void shouldGetAllUsers(){
        GetAllUsersResponse getAllUserResponse = usersClient.getAllUsers();

        Assert.assertEquals(getAllUserResponse.getStatusCode(),200);
    }



}
