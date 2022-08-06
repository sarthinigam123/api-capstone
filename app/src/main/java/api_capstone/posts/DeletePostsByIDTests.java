package api_capstone.posts;

import api_capstone.posts.PostsClient;
import api_capstone.posts.create.CreatePostResponse;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeletePostsByIDTests {
    private PostsClient postsClient;
    @BeforeClass
    public void beforeClass(){
        postsClient=new PostsClient();
    }
    @Test
    public void shouldDeletePost(){
        String id="62ec9aff29a3abc616058ab4";
        Response response= postsClient.deletePost(id);
        response
                .then()
                .statusCode(200);
    }
}
