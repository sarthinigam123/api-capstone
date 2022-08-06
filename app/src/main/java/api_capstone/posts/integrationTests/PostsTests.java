package api_capstone.posts.integrationTests;

import api_capstone.posts.PostsClient;
import api_capstone.posts.create.CreatePostRequestBody;
import api_capstone.posts.create.CreatePostResponse;
import api_capstone.posts.services.PostsServices;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostsTests {

    private PostsClient postsClient;
    private PostsServices postsService;

    @BeforeClass
    public void beforeClass(){
        postsService = new PostsServices();
        postsClient = new PostsClient();
    }

    @Test
    public void shouldCreateAndDeletePost(){
        CreatePostRequestBody body = new CreatePostRequestBody.Builder().build();
        CreatePostResponse postResponse = postsService.createPost(body);
        postResponse.assertPost(body);
        String id=postResponse.getId();
        Response response = postsClient.deletePost(id);
        response
                .then()
                .statusCode(200);
    }
}
