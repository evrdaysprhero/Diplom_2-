import io.qameta.allure.junit4.DisplayName;
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

public class RegistrationTest extends AbstractWebTest {

    private String password = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    private final String name = "sprhero" + password;
    private final String email = name + "@mailme.ru";

    private WebDriver driver = Browser.getWebDriver();

    @Before
    public void setUp() {
        RestAssured.baseURI = URL_MAIN;
    }

    @Test
    @DisplayName("Успешная регистрация")
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
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов")
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
        ApiHelper.deleteUserWithCheck(email, password);
        driver.quit();
    }
}
