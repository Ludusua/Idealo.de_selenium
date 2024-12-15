import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(xpath = "//*[@id=\"RegistrationBenefitsContainer\"]")
    private WebElement loginTitle;
    @FindBy(xpath = "//h1[normalize-space()='Anmelden']")
    private WebElement loginContainerForm;




    //    public boolean waitForLoadingLoginForm() {
//        getWait().forVisibility(loginForm);
//        return loginForm.isDisplayed();
//    }
    public boolean waitForLoadingLoginTitle() {
        getWait().forVisibility(loginTitle);
        return loginTitle.isDisplayed();

    }

    public boolean waitForLoadingLoginContainerForm() {
        getWait().forVisibility(loginContainerForm);
        return loginContainerForm.isDisplayed();
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
