import org.junit.jupiter.api.Test;


public class LoginTest extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    CookiesPage cookiesPage;
    LoginFramePage loginFramePage;

    @Test
    public void positiveLoginTest() throws InterruptedException {
        String email = "Virthunter@gmail.com";
        String password = "Ludusua12";
        //startPage = new StartPage(driver);
        //startPage.acceptCookies();
       // startPage.clickOnLoginTitle();
        // Thread.sleep(5000);
        //startPage.switchToFrame();
        loginFramePage = new LoginFramePage(driver);
        loginFramePage.waitForLoadingLoginTitle();
       //oginFramePage.waitForLoadingLoginContainerForm();
        // driver.switchTo().defaultContent();
        loginFramePage.setUserData(email,password);
        driver.get("https://www.idealo.de/");
        driver.switchTo().defaultContent();
        Thread.sleep(5000);

    }
}
