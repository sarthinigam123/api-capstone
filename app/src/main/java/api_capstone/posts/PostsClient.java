package api_capstone.posts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostsClient {
    public Response createPost(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("app-id", "62ec44a25c53f4761649efac")
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/post/create");
    }
}
