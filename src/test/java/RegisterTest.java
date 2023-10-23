import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;
import pages.RegisterPage;

@DisplayName("Страница: \"Регистрация\"")
public class RegisterTest extends BaseTest {
    Faker faker = new Faker();

    @Test
    @Feature("Registration")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка успешной регистрации")
    public void registrationTest() {
        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.clickPersonalAreaButton();
        registerPage.clickRegisterButton();
        registerPage.setNameInput(faker.name().firstName());
        registerPage.setEmailInput(faker.internet().emailAddress());
        registerPage.setPassInput(faker.internet().password());
        registerPage.clickRegistrationButton();
        registerPage.waitVisibleAuthText();
        registerPage.shouldAuthText("Вход");
    }

    @Test
    @Feature("Registration")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка регистрации с некорректным паролем")
    public void registrationIncorrectPassTest() {
        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.clickPersonalAreaButton();
        registerPage.clickRegisterButton();
        registerPage.setNameInput(faker.name().firstName());
        registerPage.setEmailInput(faker.internet().emailAddress());
        registerPage.setPassInput("1");
        registerPage.clickRegistrationButton();
        registerPage.shouldIncorrectPassError("Некорректный пароль");

    }
}