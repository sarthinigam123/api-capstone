package api_capstone.posts;

import api_capstone.posts.create.CreatePostResponse;
import api_capstone.posts.services.PostsServices;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetPostsByIDTests {
    private PostsServices postsService;
    @BeforeClass(groups={"posts"})
    public void beforeClass(){
        postsService=new PostsServices();
    }

    @Test(groups={"posts"},priority = 2)
    public void shouldGetPostsById(){
        String id = "62ee7657b6e026ba21c56308";
        CreatePostResponse postResponse= postsService.getPost(id);
        Assert.assertEquals(postResponse.getText(),"Dog");
        Assert.assertEquals(postResponse.getStatusCode(),200);
    }
}
