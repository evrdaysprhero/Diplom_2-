package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private WebDriver driver;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    private static final By PRIFILE_DESCRIPTION = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");
    private static final By CONSTRUCTOR_BUTTON = By.xpath(".//p[text()='Конструктор']");
    private static final By LOGO_BUTTON = By.xpath(".//header//div/a");

    @Step("Найти текст с описанием профиля")
    public void getDescriptionText() {
        Assert.assertTrue(driver.findElement(PRIFILE_DESCRIPTION).isDisplayed());
    }

    @Step("Клик по кнопке Конструктор")
    public void clickConstructorButton() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }

    @Step("Клик по логотипу")
    public void clickLogoButton() {
        driver.findElement(LOGO_BUTTON).click();
    }

    @Step("Войти в личный кабинет")
    public static ProfilePage enterProfile(String email, String password, WebDriver driver) {

        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickEnterButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(email,password);
        loginPage.clickEnterButton();

        mainPage.clickPersonCabinetButton();

        return new ProfilePage(driver);
    }
}
