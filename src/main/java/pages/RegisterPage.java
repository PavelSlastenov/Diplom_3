package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private final WebDriver driver;


    private final By registerButton = By.xpath("//a[@href='/register']");
    private final By nameInput = By.xpath("//input[@name='name']");
    private final By emailInput = By.xpath("//label[text()='Email']/following::input");
    private final By passInput = By.xpath("//input[@type='password']");


    private final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By authText = By.xpath("//h2[text()='Вход']");
    private final By incorrectPassError = By.xpath("//p[text()='Некорректный пароль']");

    //конструктор класса
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void setNameInput(String name) {
        driver.findElement(nameInput).click();
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setEmailInput(String email) {
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassInput(String pass) {
        driver.findElement(passInput).click();
        driver.findElement(passInput).sendKeys(pass);
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void shouldAuthText(String value) {
        Assert.assertEquals("Текст не совпадает", value, driver.findElement(authText).getText());
    }

    public void shouldIncorrectPassError(String value) {
        Assert.assertEquals("Текст не совпадает", value, driver.findElement(incorrectPassError).getText());
    }

    public void waitVisibleAuthText() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(authText));
    }
}