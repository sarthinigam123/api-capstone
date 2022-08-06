package api_capstone.posts;

import api_capstone.posts.create.Post;
import api_capstone.posts.create.CreatePostResponse;
import api_capstone.posts.services.PostsServices;
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
        Post body=new Post.Builder().build();
        CreatePostResponse postResponse= postsService.createPost(body);
        postResponse.assertPost(body);
    }



}
