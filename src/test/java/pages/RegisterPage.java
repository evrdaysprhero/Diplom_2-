package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends AbstractPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    //поля ввода
    private static final By INPUT_NAME = By.xpath(".//label[text()='Имя']/../input");
    private static final By INPUT_EMAIL = By.xpath(".//label[text()='Email']/../input");
    private static final By INPUT_PASSWORD = By.xpath(".//label[text()='Пароль']/../input");

    //кнопки
    private static final By REGISTER_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
    private static final By ENTER_BUTTON = By.xpath(".//p[text()='Уже зарегистрированы?']/a");

    //
    private static final By PASSWORD_ERROR = By.xpath(".//p[text()='Некорректный пароль']");

    public void openPage () {
        String url = URL_REGISTER;
        driver.get(url);
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
    }

    @Step("Клик по кнопке Войти")
    public void clickEnterButton() {
        driver.findElement(ENTER_BUTTON).click();
    }

    @Step("Заполнить форму регистрации")
    public void fillRegisterForm(String name, String email, String password) {

        WebElement setName = driver.findElement(INPUT_NAME);
        setName.sendKeys(name);
        setName.sendKeys(Keys.TAB);

        WebElement setEmail = driver.findElement(INPUT_EMAIL);
        setEmail.sendKeys(email);
        setEmail.sendKeys(Keys.TAB);

        WebElement setPassword = driver.findElement(INPUT_PASSWORD);
        setPassword.sendKeys(password);
        setPassword.sendKeys(Keys.TAB);

    }

    @Step("Отображается ошибка Некорректный пароль")
    public void getShortPassError() {
        driver.findElement(PASSWORD_ERROR).isDisplayed();
    }
}
