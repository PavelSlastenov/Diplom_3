package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;


public class MainPage {
    private final WebDriver driver;


    private final By personalAreaButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By emailInput = By.xpath("//label[text()='Email']/following::input");
    private final By passInput = By.xpath("//input[@type='password']");
    private final By nameInput = By.xpath("//label[text()='Имя']/../input[@name='name']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By loginOrderButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By loginRegistrationButton = By.xpath("//a[@href='/login']");
    private final By loginForgotButton = By.xpath("//a[@href='/login']");
    private final By forgotPassButton = By.xpath("//a[@href='/forgot-password']");
    private final By profileText = By.xpath("//nav[@class='Account_nav__Lgali']//p[1]");
    private final By InputText = By.xpath("//h2[text()='Вход']");
    private final By bunTab = By.xpath("//span[text()='Булки']");
    private final By bunText = By.xpath("//div[span[text()='Булки']]");
    private final By souseTab = By.xpath("//span[text()='Соусы']");
    private final By souseText = By.xpath("//div[span[text()='Соусы']]");
    private final By fillingTab = By.xpath("//span[text()='Начинки']");
    private final By fillingText = By.xpath("//div[span[text()='Начинки']]");
    private final By registrationLink = By.xpath("//a[text()='Зарегистрироваться']");
    private final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");

    //конструктор класса
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPersonalAreaButton() {
        driver.findElement(personalAreaButton).click();
    }

    public void clickLoginOrderButton() {
        driver.findElement(loginOrderButton).click();
    }

    public void clickLoginForgotButton() {
        driver.findElement(loginForgotButton).click();
    }

    public void clickForgotPassButton() {
        driver.findElement(forgotPassButton).click();
    }

    public void clickBunTab() {
        driver.findElement(bunTab).click();
    }

    public void clickSouseTab() {
        driver.findElement(souseTab).click();
    }

    public void clickFillingTab() {
        driver.findElement(fillingTab).click();
    }

    public void clickLoginRegistrationButton() {
        driver.findElement(loginRegistrationButton).click();
    }

    public void setEmailInput(String email) {
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassInput(String pass) {
        driver.findElement(passInput).click();
        driver.findElement(passInput).sendKeys(pass);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void shouldProfileText() {
        Assert.assertEquals("Текст не совпадает", "В этом разделе вы можете изменить свои персональные данные", driver.findElement(profileText).getText());
    }

    public void shouldBunTab() {
        Assert.assertTrue(driver.findElement(bunText).getAttribute("class").contains("current"));
    }

    public void shouldSouseTab() {
        Assert.assertTrue(driver.findElement(souseText).getAttribute("class").contains("current"));
    }

    public void shouldFillingTab() {
        Assert.assertTrue(driver.findElement(fillingText).getAttribute("class").contains("current"));
    }

    public void waitVisibleProfileText() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(profileText));
    }

    public void waitVisibleInputText() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(InputText));
    }

    public void createUser(String name, String email, String pass) {
        driver.findElement(registrationLink).click();
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passInput).sendKeys(pass);
        driver.findElement(registrationButton).click();

    }

    public void auth(String email, String pass) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passInput).sendKeys(pass);
        driver.findElement(loginButton).click();
    }
}