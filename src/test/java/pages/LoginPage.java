package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //кнопки
    private static final By registerButton = By.xpath(".//a[@href='/register']");
    private static final By enterButton = By.xpath(".//button[text()='Войти']");

    //поля ввода
    private static final By inputEmail = By.xpath(".//label[text()='Email']/../input");
    private static final By inputPassword = By.xpath(".//label[text()='Пароль']/../input");

    @Step("Клик по кнопке Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Заполнить форму входа")
    public void fillLoginForm(String email, String password) {

        WebElement setEmail = driver.findElement(inputEmail);
        setEmail.sendKeys(email);
        setEmail.sendKeys(Keys.TAB);

        WebElement setPassword = driver.findElement(inputPassword);
        setPassword.sendKeys(password);
        setPassword.sendKeys(Keys.TAB);

    }

    @Step("Клик по кнопке Войти")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();

    }

}
