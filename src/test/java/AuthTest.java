import models.LoginUser;
import models.RegisterUser;
import helpers.UserClient;
import helpers.UserGenerator;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import pages.RegisterPage;


@DisplayName("Авторизация")
public class AuthTest extends BaseTest {
    private RegisterUser registerData;
    private String token = "";
    private int statusCode;
    private boolean isRegistered;
    private LoginUser loginData;


//    @Rule
//    public DriverRule driverRule = new DriverRule();

    @Before
    public void setUp(){
        registerData = UserGenerator.getDefaultRegistrationData();
        ValidatableResponse responseRegister = UserClient.registerUser(registerData);

        token = responseRegister.extract().path("accessToken");
        statusCode = responseRegister.extract().statusCode();
        isRegistered = responseRegister.extract().path("success");
        loginData = UserGenerator.getDefaultLoginData();
    }

    @Test
    @Feature("Auth")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Авторизация пользователя - успешная")
    public void authTest() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickPersonalAreaButton();
        mainPage.setEmailInput(loginData.getEmail());
        mainPage.setPassInput(loginData.getPassword());
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
        mainPage.setEmailInput(loginData.getEmail());
        mainPage.setPassInput(loginData.getPassword());
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
        mainPage.setEmailInput(loginData.getEmail());
        mainPage.setPassInput(loginData.getPassword());
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
        mainPage.setEmailInput(loginData.getEmail());
        mainPage.setPassInput(loginData.getPassword());
        mainPage.clickLoginButton();
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
    }

    @After
    public void tearDown(){
        ValidatableResponse responseDelete = UserClient.deleteUser(token);
    }
}