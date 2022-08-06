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
    @BeforeClass(groups={"posts"})
    public void beforeClass(){
        postsClient=new PostsClient();
    }
    @Test(groups={"posts"},priority = 3)
    public void shouldDeletePost(){
        String id = "62ee7657b6e026ba21c56308";
        Response response = postsClient.deletePost(id);
        response
                .then()
                .statusCode(200);
    }
}
