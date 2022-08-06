package api_capstone.posts;

import api_capstone.posts.create.CreatePostResponse;
import api_capstone.posts.services.PostsServices;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPostsByIDTests {
    private PostsServices postsService;
    @BeforeClass
    public void beforeClass(){
        postsService=new PostsServices();
    }

    @Test
    public void shouldGetPostsById(){
        String id="62ecc3ed98146a9c9a3e004a";
        CreatePostResponse postResponse= postsService.getPost(id);
        Assert.assertEquals(postResponse.getText(),"Dog");
        Assert.assertEquals(postResponse.getStatusCode(),200);
    }
}
