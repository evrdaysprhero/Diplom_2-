import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;
import pogo.RegisterRequest;

import java.util.concurrent.TimeUnit;

public class ProfileTest {

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

    @Step("Войти в личный кабинет")
    public ProfilePage enterProfile(String email, String password) {

        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickEnterButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(email,password);
        loginPage.clickEnterButton();

        mainPage.clickPersonCabinetButton();

        return new ProfilePage(driver);
    }

    @Test
    @DisplayName("переход по клику на «Личный кабинет»")
    public void profilePageEnter() {

        ProfilePage profilePage = enterProfile(email, password);
        profilePage.getDescriptionText();

    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void goFromProfileToMainWithConstructorButton() {

        ProfilePage profilePage = enterProfile(email, password);
        profilePage.clickConstructorButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.isDisplayedConstructorHeader();

    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    public void goFromProfileToMainWithLogo() {

        ProfilePage profilePage = enterProfile(email, password);
        profilePage.clickLogoButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.isDisplayedConstructorHeader();

    }

    @After
    public void deleteUser() {
        if(ApiHelper.isUserExists(email,password)) {
            ApiHelper.deleteUser(email, password);
        }
        driver.quit();
    }
}
