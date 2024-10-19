import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pogo.RegisterRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class EnterTest {
    private String password;
    private String name;
    private String email;

    private WebDriver driver = Browser.getWebDriver(BrowserName.YANDEX);

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";

        password = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        name = "sprhero" + password;
        email = name + "@mailme.ru";

        //создать пользователя
        RegisterRequest registerRequest = new RegisterRequest(name, password, email);
        given()
                .header("Content-type", "application/json")
                .body(registerRequest)
                .post("/api/auth/register");
    }

    @Test
    public void buttonMainPageEnter() {

        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickEnterButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(email,password);
        loginPage.clickEnterButton();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mainPage.isDisplayedOrderButton();

    }

    @After
    public void deleteUser() {
        if(ApiHelper.isUserExists(email,password)) {
            ApiHelper.deleteUser(email, password);
        }
        driver.quit();
    }
}
