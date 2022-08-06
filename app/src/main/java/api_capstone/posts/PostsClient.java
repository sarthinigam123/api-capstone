package api_capstone.posts;

import api_capstone.posts.create.CreatePostRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostsClient {

    //Adding comment to push and check on github if pipeline has started working or not
    private String appId="62ec44a25c53f4761649efac";
    public Response createPost(CreatePostRequestBody body){
        Response response = given()
                .contentType(ContentType.JSON)
                .header("app-id", appId)
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/post/create");
        response
                .then()
                .log().body();
        return response;
    }

    public Response getPost(String id){
        return given()
                .header("app-id",appId)
                .pathParam("id",id)
                .when()
                .get("https://dummyapi.io/data/v1/post/{id}");
    }

    public Response deletePost(String id){
        return given()
                .header("app-id",appId)
                .pathParam("id",id)
                .when()
                .delete("https://dummyapi.io/data/v1/post/{id}");
    }
}
