import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;
import pages.RegisterPage;

@DisplayName("Авторизация")
public class AuthTest extends BaseTest {
    @Test
    @Feature("Auth")
    @Story("Auth")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация пользователя - успешная")
    public void authTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAreaButton();
        mainPage.setEmailInput("andrey@yandex.ru");
        mainPage.setPassInput("password");
        mainPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
    }

    @Test
    @Feature("Auth")
    @Story("Auth")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация пользователя - кнопка на главном экране")
    public void authMainButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginOrderButton();
        mainPage.setEmailInput("andrey@yandex.ru");
        mainPage.setPassInput("password");
        mainPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
    }

    @Test
    @Feature("Auth")
    @Story("Auth")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация пользователя - форма регистрации")
    public void authRegistrationFormButtonTest() {
        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.clickLoginOrderButton();
        registerPage.clickRegisterButton();
        mainPage.clickLoginRegistrationButton();
        mainPage.setEmailInput("andrey@yandex.ru");
        mainPage.setPassInput("password");
        mainPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
    }

    @Test
    @Feature("Auth")
    @Story("Auth")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация пользователя - форма восстановления пароля")
    public void authForgotFormButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginOrderButton();
        mainPage.clickForgotPassButton();
        mainPage.clickLoginForgotButton();
        mainPage.setEmailInput("andrey@yandex.ru");
        mainPage.setPassInput("password");
        mainPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
    }


}