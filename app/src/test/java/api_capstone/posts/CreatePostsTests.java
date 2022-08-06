package api_capstone.posts;

import api_capstone.posts.create.Post;
import api_capstone.posts.create.CreatePostResponse;
import api_capstone.posts.services.PostsServices;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreatePostsTests {
    private PostsServices postsService;
    @BeforeClass(groups={"posts"})
    public void beforeClass(){
        postsService = new PostsServices();
    }

    @Test(groups={"posts"}, priority = 1)
    public void shouldCreatePost(){
        Post body = new Post.Builder().build();
        CreatePostResponse postResponse = postsService.createPost(body);
        postResponse.assertPost(body);
    }

}
