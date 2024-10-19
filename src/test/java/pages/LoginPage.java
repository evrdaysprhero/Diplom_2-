package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //кнопка Зарегистрироваться
    private static final By registerButton = By.xpath(".//a[@href='/register']");

    @Step("Клик по кнопке Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

}
