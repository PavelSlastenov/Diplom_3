import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;
import pages.ProfilePage;

@DisplayName("Страница: \"Профиль\"")
public class ProfileTest extends BaseTest {
    @Test
    @Feature("Profile")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Выход из профиля")
    public void logoutTest() {
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.clickPersonalAreaButton();
        mainPage.Auth("andrey@yandex.ru", "password");
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
        profilePage.clickExitButton();
        profilePage.waitVisibleAuthText();
        profilePage.shouldAuthText("Вход");
    }

    @Test
    @Feature("Profile")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка перехода из профиля в конструктор")
    public void constructorTest() {
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.clickPersonalAreaButton();
        mainPage.Auth("andrey@yandex.ru", "password");
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
        profilePage.clickConstructorButton();
        profilePage.shouldBurgerTitle("Соберите бургер");
    }

    @Test
    @Feature("Profile")
    @Story("Profile")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка перехода из профиля в конструктор через логотип")
    public void logoTest() {
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.clickPersonalAreaButton();
        mainPage.Auth("andrey@yandex.ru", "password");
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
        profilePage.clickLogo();
        profilePage.shouldBurgerTitle("Соберите бургер");
    }

}