package api_capstone.posts.services;

import api_capstone.posts.PostsClient;
import api_capstone.posts.create.CreatePostRequestBody;
import api_capstone.posts.create.CreatePostResponse;
import io.restassured.response.Response;

public class PostsServices {
    public CreatePostResponse createPost(CreatePostRequestBody body){
        Response response=new PostsClient().createPost(body);
        CreatePostResponse postResponse=response.as(CreatePostResponse.class);
        postResponse.setStatusCode(response.statusCode());
        return postResponse;
    }

    public CreatePostResponse getPost(String id){
        Response response=new PostsClient().getPost(id);
        CreatePostResponse postResponse=response.as(CreatePostResponse.class);
        postResponse.setStatusCode(response.statusCode());
        return postResponse;
    }
}
