import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    CategoryPage categoryPage;


    @Test
    public void positiveLoginTest() {
        String email = "Virthunter@gmail.com";
        String password = "Ludusua12";
        startPage = new StartPage(driver);
        startPage.acceptCookies();
        startPage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);

    }
}
