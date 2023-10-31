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
import org.junit.Rule;
import org.junit.Test;
import pages.MainPage;
import pages.ProfilePage;

@DisplayName("Страница: \"Профиль\"")
public class ProfileTest extends BaseTest {
    private RegisterUser registerData;
    private String token = "";
    private int statusCode;
    private boolean isRegistered;
    private LoginUser loginData;

    @Rule
    public DriverRule driverRule = new DriverRule();

    private static String shouldBurgerTitle = "Соберите бургер";

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
    @Feature("Profile")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Выход из профиля")
    public void logoutTest() {
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.clickPersonalAreaButton();
        mainPage.auth(loginData.getEmail(), loginData.getPassword());
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

        mainPage.clickPersonalAreaButton();
        mainPage.auth(loginData.getEmail(), loginData.getPassword());
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
        profilePage.clickConstructorButton();
        profilePage.shouldBurgerTitle("Соберите бургер");
    }

    @Test
    @Feature("Profile")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка перехода из профиля в конструктор через логотип")
    public void logoTest() {
        MainPage mainPage = new MainPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.clickPersonalAreaButton();
        mainPage.auth(loginData.getEmail(), loginData.getPassword());
        mainPage.clickPersonalAreaButton();
        mainPage.waitVisibleProfileText();
        mainPage.shouldProfileText();
        profilePage.clickLogo();
        profilePage.shouldBurgerTitle("Соберите бургер");
    }

    @After
    public void tearDown(){
        ValidatableResponse responseDelete = UserClient.deleteUser(token);
    }
}