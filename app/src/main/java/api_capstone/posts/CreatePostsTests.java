package api_capstone.posts;

import api_capstone.users.UsersClient;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreatePostsTests {

    private PostsClient postsClient;

    @BeforeClass
    public void beforeClass(){
        postsClient = new PostsClient();
    }
    @Test
    public void shouldCreatePost(){
        String body = "{\n" +
                "\"text\":\"Dog\",\n" +
                "\"image\": \"https://www.shutterstock.com/image-photo/happy-puppy-dog-smiling-on-isolated-1799966587\",\n" +
                "\"likes\": 179,\n" +
                "\"tags\": \"[dogs]\",\n" +
                "\"owner\": \"62ec49163988ee637c5e47d2\"\n" +
                "}";

        postsClient.createPost(body)
                .then()
                .log().body()
                .statusCode(200);
    }


}
