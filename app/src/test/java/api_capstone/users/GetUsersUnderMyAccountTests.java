package api_capstone.users;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUsersUnderMyAccountTests {
    @Test(groups={"users"})
    public void shouldGetAllUsersUnderMyAccount(){
        given()
                .header("app-id","62ec44a25c53f4761649efac")
                .when()
                .get("https://dummyapi.io/data/v1/user?created=1")
                .then()
                .statusCode(200)
                .log().body();
    }
}
