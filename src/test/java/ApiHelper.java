import io.qameta.allure.Step;
import pogo.LoginRequest;
import pogo.RegisterRequest;
import pogo.RegisterResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @Step("Удалить пользователя")
    public static void deleteUser(String email, String password) {
        RegisterResponse registerResponse =  loginUser(email, password);

        String accessToken =  registerResponse.getAccessToken();

        given()
                .header("authorization", accessToken)
                .delete("/api/auth/user");

    }

    @Step("Создать пользователя")
    public static RegisterRequest createUser() {
        String password = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String name = "sprhero" + password;
        String email = name + "@mailme.ru";

        RegisterRequest registerRequest = new RegisterRequest(name, password, email);
        given()
                .header("Content-type", "application/json")
                .body(registerRequest)
                .post("/api/auth/register");

        return registerRequest;

    }
}
