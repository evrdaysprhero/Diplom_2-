import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

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



    @After
    public void deleteUser() {
        driver.quit();
    }
}
