import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage{
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

    public void waitForLoadingLoginPage(){
        getWait().forVisibility(emailInputField);
        assertTrue(emailInputField.isDisplayed());
    }
    public void setEmailInputField(String email){
        getWait().forVisibility(emailInputField);
        emailInputField.sendKeys(email);
    }
    public void setPasswordInputField(String password){
        getWait().forVisibility(passwordInputField);
        passwordInputField.sendKeys(password);
    }
    public void clickOnLoginButton(){
        getWait().forVisibility(registrationButton);
        registrationButton.click();
    }

}

