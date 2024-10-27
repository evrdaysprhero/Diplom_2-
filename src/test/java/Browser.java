import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

    public static WebDriver getWebDriver(BrowserName browser) {
        switch (browser) {
            case CHROME :
                return new ChromeDriver();
            case YANDEX :
                System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\yandexdriver-24.10.1.598-win64\\yandexdriver.exe");
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
