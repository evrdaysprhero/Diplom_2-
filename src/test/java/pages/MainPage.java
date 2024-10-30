package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    //кнопки
    private static final By CABINET_BUTTON = By.xpath(".//header//p[text()='Личный Кабинет']");
    private static final By ENTER_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    private static final By CREATE_ORDER_BUTTON = By.xpath(".//button[text()='Оформить заказ']");

    //Конструктор: заголовок
    private static final By CONSTRUCTOR_HEADER = By.xpath(".//h1[text()='Соберите бургер']");

    //Конструктор: меню
    private static final By BREAD_BUTTON = By.xpath(".//span[text()='Булки']");
    private static final By BREAD_BUTTON_ACTIVE = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc')]/span[text()='Булки']");
    private static final By SOUSES_BUTTON = By.xpath(".//span[text()='Соусы']");
    private static final By SOUSES_BUTTON_ACTIVE = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc')]/span[text()='Соусы']");
    private static final By FILLERS_BUTTON = By.xpath(".//span[text()='Начинки']");
    private static final By FILLERS_BUTTON_ACTIVE = By.xpath(".//div[contains(@class,'tab_tab_type_current__2BEPc')]/span[text()='Начинки']");
    private static final By BREAD_HEADER = By.xpath(".//h2[text()='Булки']");

    private static final By SOUCES_HEADER = By.xpath(".//h2[text()='Соус']");
    private static final By FILLERS_HEADER = By.xpath(".//h2[text()='Начинки']");


    public void openPage () {
        String url = URL_MAIN;
        driver.get(url);
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickPersonCabinetButton() {
        driver.findElement(CABINET_BUTTON).click();
    }

    @Step("Клик по кнопке Войти в аккаунт")
    public void clickEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
    }

    @Step("Клик по кнопке Булки")
    public void clickBreadButton() {
        driver.findElement(BREAD_BUTTON).click();
    }

    @Step("Клик по кнопке Соус")
    public void clickSoucesButton() {
        driver.findElement(SOUSES_BUTTON).click();
    }

    @Step("Клик по кнопке Начинки")
    public void clickFillersButton() {
        driver.findElement(FILLERS_BUTTON).click();
    }

    @Step("Есть кнопка Оформить заказ")
    public void isDisplayedOrderButton() {
        Assert.assertTrue(driver.findElement(CREATE_ORDER_BUTTON).isDisplayed());
    }

    @Step("Есть заголовок Соберите бургер")
    public void isDisplayedConstructorHeader() {
        Assert.assertTrue(driver.findElement(CONSTRUCTOR_HEADER).isDisplayed());
    }

    @Step("Активна вкладка Соус")
    public void isSoucesActive() {
        Assert.assertTrue(driver.findElement(SOUSES_BUTTON_ACTIVE).isDisplayed());
    }

    @Step("Активна вкладка Булки")
    public void isBreadActive() {
        Assert.assertTrue(driver.findElement(BREAD_BUTTON_ACTIVE).isDisplayed());
    }

    @Step("Активна вкладка Начинки")
    public void isFillersActive() {
        Assert.assertTrue(driver.findElement(FILLERS_BUTTON_ACTIVE).isDisplayed());
    }

}
