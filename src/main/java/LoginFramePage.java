import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginFramePage extends BasePage {
    public LoginFramePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//iframe[contains(@src, 'idealo.de')]")
    public WebElement iframe;
    @FindBy(xpath = "//input[@id='LoginEmail']")
    private WebElement emailInputField;
    @FindBy(xpath = "//input[@id='LoginPassword']")
    private WebElement passwordInputField;
    @FindBy(xpath = "//*[@id='LoginWithEmail']")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@class='ac-login-form']")
    private WebElement loginForm;

    public boolean waitForLoadingLoginForm() {
        getWait().forVisibility(loginForm);
        return loginForm.isDisplayed();
    }
    public void switchToFrame(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }

    public void setUserData(String email, String password) {
        getWait().forVisibility(emailInputField);
        emailInputField.sendKeys(email);
        getWait().forVisibility(passwordInputField);
        passwordInputField.sendKeys(password);
        getWait().forVisibility(loginButton);
        loginButton.click();
    }
}
