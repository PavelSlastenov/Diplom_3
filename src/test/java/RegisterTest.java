import helpers.UserClient;
import helpers.UserGenerator;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import models.LoginUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pages.MainPage;
import pages.RegisterPage;

@DisplayName("Страница: \"Регистрация\"")
public class RegisterTest extends BaseTest {
    private String token = "";
    private LoginUser loginData;

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Before
    public void setUp(){
        loginData = UserGenerator.getDefaultLoginData();
    }

    @Test
    @Feature("Registration")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка успешной регистрации")
    public void registrationTest() {
        MainPage mainPage = new MainPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickPersonalAreaButton();
        registerPage.clickRegisterButton();
        registerPage.setNameInput(loginData.getName());
        registerPage.setEmailInput(loginData.getEmail());
        registerPage.setPassInput(loginData.getPassword());
        registerPage.clickRegistrationButton();
        registerPage.waitVisibleAuthText();
        registerPage.shouldAuthText("Вход");

        ValidatableResponse responseRegister = UserClient.loginUser(loginData);
        token = responseRegister.extract().path("accessToken");
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
        registerPage.setNameInput(loginData.getName());
        registerPage.setEmailInput(loginData.getEmail());
        registerPage.setPassInput("1");
        registerPage.clickRegistrationButton();
        registerPage.shouldIncorrectPassError("Некорректный пароль");
    }

    @After
    public void tearDown(){
        ValidatableResponse responseDelete = UserClient.deleteUser(token);
    }
}