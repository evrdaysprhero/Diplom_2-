package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //кнопки
    private static final By REGISTER_BUTTON = By.xpath(".//a[@href='/register']");
    private static final By ENTER_BUTTON = By.xpath(".//button[text()='Войти']");
    private static final By FORGOT_PASS_BUTTON = By.xpath(".//p[text()='Забыли пароль?']/a");

    //поля ввода
    private static final By INPUT_EMAIL = By.xpath(".//label[text()='Email']/../input");
    private static final By INPUT_PASSWORD = By.xpath(".//label[text()='Пароль']/../input");

    public void openPage () {
        String url = URL_LOGIN;
        driver.get(url);
    }

    @Step("Клик по кнопке Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
    }

    @Step("Заполнить форму входа")
    public void fillLoginForm(String email, String password) {

        WebElement setEmail = driver.findElement(INPUT_EMAIL);
        setEmail.sendKeys(email);
        setEmail.sendKeys(Keys.TAB);

        WebElement setPassword = driver.findElement(INPUT_PASSWORD);
        setPassword.sendKeys(password);
        setPassword.sendKeys(Keys.TAB);

    }

    @Step("Клик по кнопке Войти")
    public void clickEnterButton() {
        driver.findElement(ENTER_BUTTON).click();

    }

    @Step("Клик по кнопке Восстановить пароль")
    public void clickRestorePasswordrButton() {
        driver.findElement(FORGOT_PASS_BUTTON).click();

    }

}
