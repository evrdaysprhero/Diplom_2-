package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    //кнопки
    private static final By cabinetButton = By.xpath(".//header//p[text()='Личный Кабинет']");
    private static final By enterButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private static final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");

    //Конструктор: заголовок
    private static final By constuctorHeader = By.xpath(".//h1[text()='Соберите бургер']");


    public void openPage () {
        String url = "https://stellarburgers.nomoreparties.site/";
        driver.get(url);
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickPersonCabinetButton() {
        driver.findElement(cabinetButton).click();
    }

    @Step("Клик по кнопке Войти в аккаунт")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Есть кнопка Оформить заказ")
    public void isDisplayedOrderButton() {
        driver.findElement(createOrderButton).isDisplayed();
    }

    @Step("Есть заголовок Соберите бургер")
    public void isDisplayedConstructorHeader() {
        driver.findElement(constuctorHeader).isDisplayed();
    }

}
