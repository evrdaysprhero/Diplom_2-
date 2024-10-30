import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Browser {

    public static String getBrowserName() {
        Properties properties = new Properties();
        try (InputStream input = Browser.class.getClassLoader().getResourceAsStream("data.properties")) {
            properties.load(input);
            return properties.getProperty("browser", "YANDEX");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка получения свойств", e);
        }
    }

    public static WebDriver getWebDriver() {

        String browser = getBrowserName();

        return switch (browser) {
            case "CHROME" -> new ChromeDriver();
            case "YANDEX" -> new ChromeDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };
    }
}
