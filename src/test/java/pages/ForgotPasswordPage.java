package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {

    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    //поля ввода
    private static final By inputEmail = By.xpath(".//label[text()='Email']/../input");

    //кнопки
    private static final By restoreButton = By.xpath(".//button[text()='Восстановить']");

    @Step("Заполнить email")
    public void fillEmailForm(String email) {

        WebElement setEmail = driver.findElement(inputEmail);
        setEmail.sendKeys(email);
        setEmail.sendKeys(Keys.TAB);

    }

    @Step("Клик по кнопке Восстановить")
    public void clickRestoreButton() {
        driver.findElement(restoreButton).click();
    }

}
