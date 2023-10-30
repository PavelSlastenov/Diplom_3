import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;
import pages.ProfilePage;

@DisplayName("Страница: \"Профиль\"")
public class ProfileTest extends BaseTest {
    Faker faker = new Faker();

    private static String shouldBurgerTitle = "Соберите бургер";

    @Test
    @Feature("Profile")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Выход из профиля")
    public void logoutTest() {
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        mainPage.clickPersonalAreaButton();
        mainPage.createUser(name, email, password);
        mainPage.waitVisibleInputText();
        mainPage.auth(email, password);
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
    public void constructorTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        mainPage.clickPersonalAreaButton();
        mainPage.createUser(name, email, password);
        mainPage.waitVisibleInputText();
        mainPage.auth(email, password);
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
        profilePage.clickConstructorButton();
        profilePage.shouldBurgerTitle(shouldBurgerTitle);
    }

    @Test
    @Feature("Profile")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка перехода из профиля в конструктор через логотип")
    public void logoTest() {
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        mainPage.clickPersonalAreaButton();
        mainPage.createUser(name, email, password);
        mainPage.waitVisibleInputText();
        mainPage.auth(email, password);
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
        profilePage.clickLogo();
        profilePage.shouldBurgerTitle(shouldBurgerTitle);
    }
}