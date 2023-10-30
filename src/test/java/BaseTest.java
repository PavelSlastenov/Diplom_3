import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static constants.ConfigUrl.BASE_PATH;

public class BaseTest {
    protected WebDriver driver;

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}