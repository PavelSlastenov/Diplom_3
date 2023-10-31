package helpers;

public class EnvConfig {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final int DEFAULT_TIMEOUT = 10;

    public static final String CHROME_DRIVER = System.getProperty("webdriver.chrome.driver", "/opt/chromedriver/chromedriver");
    public static final String CHROME_BINARY = System.getProperty("webdriver.chrome.binary", "/opt/chrome-for-testing/chrome");
    public static final String YANDEX_DRIVER = System.getProperty("webdriver.yandex.driver", "/opt/chromedriver/chromedriver-114");
    public static final String YANDEX_BINARY = System.getProperty("webdriver.yandex.binary", "/usr/bin/yandex-browser");
    public static final String FIREFOX_DRIVER = System.getProperty("webdriver.gecko.driver", "/opt/geckodriver/geckodriver");
    public static final String FIREFOX_BINARY = System.getProperty("webdriver.gecko.binary", "/usr/bin/firefox");
}