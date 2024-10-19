import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistrationTest {

    private String password = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    private final String name = "sprhero" + password;
    private final String email = name + "@mailme.ru";

    private WebDriver driver = Browser.getWebDriver(BrowserName.YANDEX);

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    }

    @Test
    public void registrationSuccess() {

        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickPersonCabinetButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillRegisterForm(name,email,password);
        registerPage.clickRegisterButton();

        Assert.assertTrue(ApiHelper.isUserExists(email,password));

    }

    @Test
    public void registrationShortPassFail() {
        password = "12345";

        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickPersonCabinetButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillRegisterForm(name,email,password);
        registerPage.getShortPassError();

        registerPage.clickRegisterButton();
        registerPage.getShortPassError();

    }

    @After
    public void deleteUser() {
        if(ApiHelper.isUserExists(email,password)) {
            ApiHelper.deleteUser(email, password);
        }
        driver.quit();
    }
}
