package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    //поля ввода
    private static final By inputName = By.xpath(".//label[text()='Имя']/../input");
    private static final By inputEmail = By.xpath(".//label[text()='Email']/../input");
    private static final By inputPassword = By.xpath(".//label[text()='Пароль']/../input");

    //кнопки
    private static final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    //
    private static final By passwordError = By.xpath(".//p[text()='Некорректный пароль']");

    @Step("Клик по кнопке Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Заполнить форму регистрации")
    public void fillRegisterForm(String name, String email, String password) {

        WebElement setName = driver.findElement(inputName);
        setName.sendKeys(name);
        setName.sendKeys(Keys.TAB);

        WebElement setEmail = driver.findElement(inputEmail);
        setEmail.sendKeys(email);
        setEmail.sendKeys(Keys.TAB);

        WebElement setPassword = driver.findElement(inputPassword);
        setPassword.sendKeys(password);
        setPassword.sendKeys(Keys.TAB);

    }

    @Step
    public void getShortPassError() {
        driver.findElement(passwordError).isDisplayed();
    }
}
