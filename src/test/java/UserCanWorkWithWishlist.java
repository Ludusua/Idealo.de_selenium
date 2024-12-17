import org.junit.jupiter.api.Test;


public class UserCanWorkWithWishlist extends BaseTest{

    LoginPage loginPage;
    StartPage startPage;
    CategoryPage categoryPage;
    SubCategoryPage subCategoryPage;
    ItemsListPage itemsListPage;
    ItemPage itemPage;

    @Test
    public void wishlistTest() {
        startPage = new StartPage(driver);
        startPage.acceptCookies();
        startPage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
    }
}
