package api_capstone.posts;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPostsByIDTests {

    @Test
    public void shouldGetPostsByID() {

        given()
                .header("app-id", "62ec44a25c53f4761649efac")
                .when()
                .get("https://dummyapi.io/data/v1/user/{postID}/post?limit=10")
                .then()
                .statusCode(200)
                .log().body();
    }
}
