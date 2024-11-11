import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{
    LoginPage loginPage;
    StartPage startPage;
    @Test
    public void positiveLoginTest(){
        String email = "Virthunter@gmail.com";
        String password = "Ludusua12";
        startPage = new StartPage(driver);
        startPage.clickOnLoginTitle();
        loginPage = new LoginPage(driver);
        loginPage.setEmailInputField(email);
        loginPage.setPasswordInputField(password);
        loginPage.clickOnLoginButton();
    }
}
