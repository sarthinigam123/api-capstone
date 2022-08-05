package api_capstone.posts;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePostsByIDTests {
    @Test
    public void shouldDeletePost(){
        given()
                .header("app-id","62ec44a25c53f4761649efac")
                .when()
                .delete("https://dummyapi.io/data/v1/post/62ecc3ed98146a9c9a3e004a")
                .then()
                .statusCode(200)
                .log().body();
    }
}
