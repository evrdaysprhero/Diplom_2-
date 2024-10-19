import pogo.LoginRequest;
import pogo.RegisterResponse;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    public static RegisterResponse loginUser(String email, String password) {
        LoginRequest loginRequest = new LoginRequest(password, email);

        return given()
                .header("Content-type", "application/json")
                .body(loginRequest)
                .post("/api/auth/login")
                .body()
                .as(RegisterResponse.class);

    }

    public static boolean isUserExists(String email, String password) {
        RegisterResponse registerResponse =  loginUser(email, password);
        return registerResponse.isSuccess();

    }

    public static void deleteUser(String email, String password) {
        RegisterResponse registerResponse =  loginUser(email, password);

        String accessToken =  registerResponse.getAccessToken();

        given()
                .header("authorization", accessToken)
                .delete("/api/auth/user");

    }
}
