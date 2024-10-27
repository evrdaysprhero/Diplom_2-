import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;
import pogo.RegisterRequest;

import java.util.concurrent.TimeUnit;

public class EnterTest {
    private String password;
    private String email;

    private WebDriver driver = Browser.getWebDriver(BrowserName.YANDEX);

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        RegisterRequest registerRequest = ApiHelper.createUser();
        password = registerRequest.getPassword();
        email = registerRequest.getEmail();

    }

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void buttonMainPageEnter() {

        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickEnterButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(email,password);
        loginPage.clickEnterButton();

        mainPage.isDisplayedOrderButton();

    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void buttonCabinetEnter() {

        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickPersonCabinetButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(email,password);
        loginPage.clickEnterButton();

        mainPage.isDisplayedOrderButton();

    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void buttonRegistrationFormEnter() {

        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickPersonCabinetButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickEnterButton();

        loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(email,password);
        loginPage.clickEnterButton();

        mainPage = new MainPage(driver);
        mainPage.isDisplayedOrderButton();

    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void buttonRstorePasswirdEnter() {

        ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
        resetPasswordPage.openPage();
        resetPasswordPage.clickEnterButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(email,password);
        loginPage.clickEnterButton();

        MainPage mainPage;
        mainPage = new MainPage(driver);
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
