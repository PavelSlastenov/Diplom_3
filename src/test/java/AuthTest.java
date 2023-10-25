import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;
import pages.RegisterPage;

import static helpers.AuthData.email;
import static helpers.AuthData.password;

@DisplayName("Авторизация")
public class AuthTest extends BaseTest {
    @Test
    @Feature("Auth")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация пользователя - успешная")
    public void authTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAreaButton();
        mainPage.setEmailInput(email);
        mainPage.setPassInput(password);
        mainPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
    }

    @Test
    @Feature("Auth")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация пользователя - кнопка на главном экране")
    public void authMainButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginOrderButton();
        mainPage.setEmailInput(email);
        mainPage.setPassInput(password);
        mainPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
    }

    @Test
    @Feature("Auth")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация пользователя - форма регистрации")
    public void authRegistrationFormButtonTest() {
        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.clickLoginOrderButton();
        registerPage.clickRegisterButton();
        mainPage.clickLoginRegistrationButton();
        mainPage.setEmailInput(email);
        mainPage.setPassInput(password);
        mainPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
    }

    @Test
    @Feature("Auth")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация пользователя - форма восстановления пароля")
    public void authForgotFormButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginOrderButton();
        mainPage.clickForgotPassButton();
        mainPage.clickLoginForgotButton();
        mainPage.setEmailInput(email);
        mainPage.setPassInput(password);
        mainPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
    }
}