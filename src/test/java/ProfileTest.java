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

public class ProfileTest extends AbstractWebTest {

    private String password;
    private String email;

    private WebDriver driver = Browser.getWebDriver();

    @Before
    public void setUp() {
        RestAssured.baseURI = URL_MAIN;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        RegisterRequest registerRequest = ApiHelper.createUser();
        password = registerRequest.getPassword();
        email = registerRequest.getEmail();

    }

    @Test
    @DisplayName("переход по клику на «Личный кабинет»")
    public void profilePageEnter() {

        ProfilePage profilePage = ProfilePage.enterProfile(email, password, driver);
        profilePage.getDescriptionText();

    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void goFromProfileToMainWithConstructorButton() {

        ProfilePage profilePage = ProfilePage.enterProfile(email, password, driver);
        profilePage.clickConstructorButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.isDisplayedConstructorHeader();

    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    public void goFromProfileToMainWithLogo() {

        ProfilePage profilePage = ProfilePage.enterProfile(email, password, driver);
        profilePage.clickLogoButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.isDisplayedConstructorHeader();

    }

    @After
    public void deleteUser() {
        ApiHelper.deleteUserWithCheck(email, password);
        driver.quit();
    }
}
