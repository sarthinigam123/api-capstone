package api_capstone.users.create.response;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class CreateUserErrorResponse {

    private String error;
    private Data data;

    @Setter
    private int statusCode;

    @Getter
    private static class Data {
        private String email;
    }

    public void assertResponse(String email) {
        Assert.assertEquals(this.statusCode,400);
        Assert.assertEquals(this.error,"BODY_NOT_VALID");
        Assert.assertEquals(this.data.getEmail(),"Path `email` is invalid (" + email + ").");
    }
}
