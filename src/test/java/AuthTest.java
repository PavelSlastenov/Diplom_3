import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;
import pages.ProfilePage;
import pages.RegisterPage;


@DisplayName("Авторизация")
public class AuthTest extends BaseTest {
    Faker faker = new Faker();
    ProfilePage profilePage = new ProfilePage(driver);

    @Test
    @Feature("Auth")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация пользователя - успешная")
    public void authTest() {
        MainPage mainPage = new MainPage(driver);

        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        mainPage.clickPersonalAreaButton();
        mainPage.createUser(name, email, password);
        mainPage.waitVisibleInputText();
        mainPage.setEmailInput(email);
        mainPage.setPassInput(password);
        mainPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
//        mainPage.clickPersonalAreaButton();
//        profilePage.clickExitButton();
    }

    @Test
    @Feature("Auth")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация пользователя - кнопка на главном экране")
    public void authMainButtonTest() {
        MainPage mainPage = new MainPage(driver);

        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        mainPage.clickLoginOrderButton();
        mainPage.createUser(name, email, password);
        mainPage.waitVisibleInputText();
        mainPage.setEmailInput(email);
        mainPage.setPassInput(password);
        mainPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
//        mainPage.clickPersonalAreaButton();
//        profilePage.clickExitButton();
    }

    @Test
    @Feature("Auth")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация пользователя - форма регистрации")
    public void authRegistrationFormButtonTest() {
        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        mainPage.clickLoginOrderButton();
        registerPage.clickRegisterButton();
        mainPage.clickLoginRegistrationButton();
        mainPage.createUser(name, email, password);
        mainPage.waitVisibleInputText();
        mainPage.setEmailInput(email);
        mainPage.setPassInput(password);
        mainPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
//        mainPage.clickPersonalAreaButton();
//        profilePage.clickExitButton();
    }

    @Test
    @Feature("Auth")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация пользователя - форма восстановления пароля")
    public void authForgotFormButtonTest() {
        MainPage mainPage = new MainPage(driver);

        String name = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        mainPage.clickLoginOrderButton();
        mainPage.clickForgotPassButton();
        mainPage.clickLoginForgotButton();
        mainPage.createUser(name, email, password);
        mainPage.waitVisibleInputText();
        mainPage.setEmailInput(email);
        mainPage.setPassInput(password);
        mainPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
//        mainPage.clickPersonalAreaButton();
//        profilePage.clickExitButton();
    }
}