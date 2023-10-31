import org.junit.After;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}