import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class ConstructorTest {

    private WebDriver driver = Browser.getWebDriver(BrowserName.YANDEX);

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
    }

    @Test
    @DisplayName("переход к начинкам")
    public void goToFillers() {

        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickFillersButton();
        mainPage.isFillersActive();

    }

    @Test
    @DisplayName("переход к булкам")
    public void goToBread() {

        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickFillersButton();
        mainPage.clickBreadButton();
        mainPage.isBreadActive();

    }

    @Test
    @DisplayName("переход к соусам")
    public void goToSouces() {

        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickSoucesButton();
        mainPage.isSoucesActive();

    }

    @After
    public void deleteUser() {
        driver.quit();
    }
}
