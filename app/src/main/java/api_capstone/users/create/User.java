package api_capstone.users.create;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private String firstName;
    private String lastName;
    private String email;

}
