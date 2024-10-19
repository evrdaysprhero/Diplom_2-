package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    //кнопка Личный кабинет
    private static final By cabinetButton = By.xpath(".//header//p[text()='Личный Кабинет']");

    public void openPage () {
        String url = "https://stellarburgers.nomoreparties.site/";
        driver.get(url);
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickPersonCabinetButton() {
        driver.findElement(cabinetButton).click();
    }

}
