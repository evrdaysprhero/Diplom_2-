package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private WebDriver driver;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    private static final By profileDescription = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");
    private static final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private static final By logoButton = By.xpath(".//header//div/a");

    @Step("Найти текст с описанием профиля")
    public void getDescriptionText() {
        driver.findElement(profileDescription).isDisplayed();
    }

    @Step("Клик по кнопке Конструктор")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Клик по логотипу")
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }
}
