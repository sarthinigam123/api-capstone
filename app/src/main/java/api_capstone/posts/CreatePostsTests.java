package api_capstone.posts;

import api_capstone.posts.create.CreatePostRequestBody;
import api_capstone.posts.create.CreatePostResponse;
import api_capstone.posts.services.PostsServices;
import api_capstone.users.UsersClient;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreatePostsTests {
    private PostsServices postsService;
    @BeforeClass
    public void beforeClass(){
        postsService=new PostsServices();
    }

    @Test
    public void shouldCreatePost(){
        CreatePostRequestBody body=new CreatePostRequestBody.Builder().build();
        CreatePostResponse postResponse= postsService.createPost(body);
        postResponse.assertPost(body);
    }



}
