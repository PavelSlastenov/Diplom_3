import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pages.MainPage;

@DisplayName("Конструктор")
public class MainTest extends BaseTest {
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка перехода в раздел: Соусы")
    public void souseTabTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSouseTab();
        mainPage.shouldSouseTab();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка перехода в раздел: Булки")
    public void bunTabTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSouseTab();
        mainPage.clickBunTab();
        mainPage.shouldBunTab();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка перехода в раздел: Начинки")
    public void fillingTabTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingTab();
        mainPage.shouldFillingTab();
    }
}