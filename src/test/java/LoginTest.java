import org.junit.jupiter.api.Test;


public class LoginTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;

    @Test
    public void positiveLoginTest() {
        startPage = new StartPage(driver);
        startPage.acceptCookies();
        startPage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
    }
}
