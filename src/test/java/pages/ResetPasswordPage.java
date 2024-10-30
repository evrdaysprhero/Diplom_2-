package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage extends AbstractPage{

    private WebDriver driver;

    public ResetPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    private static final By REMEMER_PASSWORD_BUTTON = By.xpath(".//p[text()='Вспомнили пароль?']/a");

    public void openPage () {
        String url = URL_FORGOT_PASSWORD;
        driver.get(url);
    }

    @Step("Клик по кнопке Войти")
    public void clickEnterButton() {
        driver.findElement(REMEMER_PASSWORD_BUTTON).click();
    }
}
