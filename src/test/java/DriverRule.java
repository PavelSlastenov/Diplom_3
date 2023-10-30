
import helpers.EnvConfig;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverRule extends ExternalResource {
    WebDriver driver;

    @Override
    protected void before() throws Throwable {
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        if ("firefox".equals(System.getProperty("browser")))
            setUpFirefox();
        else if ("yandex".equals(System.getProperty("browser")))
            setUpYandex();
        else
            setUpChrome();

        // Преобразование Duration в миллисекунды
        long implicitWaitTimeout = Duration.ofSeconds(10).toMillis();

        driver.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.MILLISECONDS);
    }

    private void setUpChrome() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(EnvConfig.CHROME_DRIVER))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary(EnvConfig.CHROME_BINARY);

        driver = new ChromeDriver(service, options);
    }

    public void setUpYandex() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(EnvConfig.YANDEX_DRIVER))
                .build();
        ChromeOptions options = new ChromeOptions()
                .setBinary(EnvConfig.YANDEX_BINARY);

        driver = new ChromeDriver(service, options);
    }

    public void setUpFirefox() {
        var service = new GeckoDriverService.Builder()
                .usingDriverExecutable(new File(EnvConfig.FIREFOX_DRIVER))
                .build();

        var options = new FirefoxOptions()
                .setBinary(EnvConfig.FIREFOX_BINARY);

        driver = new FirefoxDriver(service, options);
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}