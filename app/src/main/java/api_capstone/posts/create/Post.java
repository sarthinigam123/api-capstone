package api_capstone.posts.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Post {
    private String text;
    private String image;
    private String owner;
    private List<String> tags;
    private int likes;

    public Post(Builder builder) {
        this.text= builder.text;
        this.image=builder.image;
        this.likes=builder.likes;
        this.owner=builder.owner;
        this.tags=builder.tags;
    }

    public static class Builder{
        private String text;
        private String image;
        private String owner;
        @JsonProperty("tags")
        private List<String> tags;
        private int likes;
        public Builder(){
            text="Dog";
            image="https://www.shutterstock.com/image-photo/happy-puppy-dog-smiling-on-isolated-1799966587";
            likes=179;
            owner="62ec49163988ee637c5e47d2";
            tags=new ArrayList<>();
        }

        public Post build(){
            Post requestBody=new Post(this);
            return requestBody;
        }

    }
}
