import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='RegistrationEmail']")
    private WebElement emailInputField;
    @FindBy(xpath = "//*[@class='ac-form-element--password']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//*[@id='RegisterWithEmail']")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@class='i-button i-button--expanded']")
    private WebElement registrationButton;

    public void login(String email, String password) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[src*='register?mode=iframe']")));
            emailInputField.sendKeys(email);
            passwordInputField.sendKeys(password);
            loginButton.click();
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForLoadingLoginPage() {
        getWait().forVisibility(emailInputField);
        assertTrue(emailInputField.isDisplayed());
    }



}

