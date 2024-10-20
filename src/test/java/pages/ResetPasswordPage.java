package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage {

    private WebDriver driver;

    public ResetPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    private static final By rememberedPasswordButton = By.xpath(".//p[text()='Вспомнили пароль?']/a");

    public void openPage () {
        String url = "https://stellarburgers.nomoreparties.site/forgot-password";
        driver.get(url);
    }

    @Step("Клик по кнопке Войти")
    public void clickEnterButton() {
        driver.findElement(rememberedPasswordButton).click();
    }
}
