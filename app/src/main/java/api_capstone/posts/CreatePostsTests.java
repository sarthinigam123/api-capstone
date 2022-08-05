package api_capstone.posts;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreatePostsTests {
    @Test
    public void shouldCreatePost(){
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("app-id","62ec44a25c53f4761649efac")
                .body("{\n" +
                        "\"text\":\"Dog\",\n" +
                        "\"image\": \"https://www.shutterstock.com/image-photo/portrait-golden-retriever-dog-tongue-1907726029\",\n" +
                        "\"likes\": 179,\n" +
                        "\"tags\": \"[dogs]\",\n" +
                        "\"owner\": \"62ec49163988ee637c5e47d2\"\n" +
                        "}")
                .when()
                .post("https://dummyapi.io/data/v1/post/create")
                .then()
                .log().body()
                .statusCode(200);
    }
}
