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

public class ConstructorTest {

    private WebDriver driver = Browser.getWebDriver(BrowserName.YANDEX);

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
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
    @DisplayName("Переход из личного кабинета в конструктор по клику на «Конструктор»")
    public void goFromProfileToMainWithConstructorButton() {
        RegisterRequest userData = ApiHelper.createUser();
        String email = userData.getEmail();
        String password = userData.getPassword();

        ProfilePage profilePage = enterProfile(email, password);
        profilePage.clickConstructorButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.isDisplayedConstructorHeader();

        ApiHelper.deleteUser(email, password);

    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    public void goFromProfileToMainWithLogo() {
        RegisterRequest userData = ApiHelper.createUser();
        String email = userData.getEmail();
        String password = userData.getPassword();

        ProfilePage profilePage = enterProfile(email, password);
        profilePage.clickLogoButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.isDisplayedConstructorHeader();

        ApiHelper.deleteUser(email, password);

    }

    @After
    public void deleteUser() {
        driver.quit();
    }
}
