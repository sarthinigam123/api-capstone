package api_capstone.posts.create;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CreatePostRequestBody {
    private String text;
    private String image;
    private String owner;
    private List<String> tags;
    private int likes;
}
