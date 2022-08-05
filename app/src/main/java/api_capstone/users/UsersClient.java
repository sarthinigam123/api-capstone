package api_capstone.users;

import api_capstone.users.create.CreateUserRequestBody;
import api_capstone.users.create.response.CreateUserErrorResponse;
import api_capstone.users.create.response.CreateUserResponse;
import api_capstone.users.getAll.GetAllUsersResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {
    public CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatusCode(response.statusCode());
        return createUserResponse;
    }

    public CreateUserErrorResponse createUserExpectingError(CreateUserRequestBody body){
        Response response = create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.statusCode());
        return errorResponse;
    }

    public Response create(CreateUserRequestBody body) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("app-id", "62ec44a25c53f4761649efac")
                .body(body)
                .when()
                .post("https://dummyapi.io/data/v1/user/create");

        response.then()
                .log().body();
        return response;
    }

    public GetAllUsersResponse getAllUsers() {
        Response response = given()
                .header("app-id", "62ec44a25c53f4761649efac")
                .when()
                .get("https://dummyapi.io/data/v1/user");

        response.then().log().body();

        int statusCode = response.statusCode();
        GetAllUsersResponse getAllUsersResponse = response.as(GetAllUsersResponse.class);

        getAllUsersResponse.setStatusCode(statusCode);
        return getAllUsersResponse;
    }
}
