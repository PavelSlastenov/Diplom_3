package pages;

//import org.junit.Assert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private final WebDriver driver;


    private final By constructorButton = By.xpath("//p[text()='Конструктор']");
    private final By exitButton = By.xpath("//button[text()='Выход']");
    private final By authText = By.xpath("//h2[text()='Вход']");
    private final By burgerTitle = By.xpath("//h1[text()='Соберите бургер']");
    private final By logo = By.xpath("//a[@href='/']");

    //конструктор класса
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    public void shouldAuthText(String value) {
        Assert.assertEquals("Текст не совпадает", value, driver.findElement(authText).getText());
    }

    public void shouldBurgerTitle(String value) {
        Assert.assertEquals("Текст не совпадает", value, driver.findElement(burgerTitle).getText());
    }

    public void waitVisibleAuthText() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(authText));
    }
}