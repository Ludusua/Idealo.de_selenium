import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class UserCanWorkWithWishlist extends BaseTest {

    LoginPage loginPage;
    StartPage startPage;
    WishListPage wishListPage;
    @Test
    public void wishlistISEmptyTest() {
        startPage = new StartPage(driver);
        startPage.acceptCookies();
        startPage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickWishlistButton();
        wishListPage = new WishListPage(driver);
        assertTrue(wishListPage.emptyWishlistIsDisplayed());
    }
    @Test
    public void wishlistContainsItem() {
        String itemName="Animal Crossing: New Leaf (3DS)";
        startPage = new StartPage(driver);
        startPage.acceptCookies();
        startPage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.clickWishlistButton();
        wishListPage = new WishListPage(driver);
        assertTrue(wishListPage.itemAvailable(itemName));
    }
}
