import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    CookiesPage cookiesPage;

    @Test
    public void positiveLoginTest() throws InterruptedException {
        String email = "Virthunter@gmail.com";
        String password = "Ludusua12";
        startPage = new StartPage(driver);
        startPage.acceptCookies();
        startPage.clickOnLoginTitle();
        loginPage = new LoginPage(driver);
        loginPage.setEmailInputField(email);
        loginPage.setPasswordInputField(password);
        loginPage.clickOnLoginButton();
    }
}
