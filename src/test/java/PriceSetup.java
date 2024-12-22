import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PriceSetup extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    ItemsListPage itemsListPage;
    ItemPage itemPage;
    WishPriceSetupPage wishPriceSetupPage;
    SuccessWishPriceSetupPage successWishPriceSetupPage;

    @Test
    public void setAlertPriseDiscount15() throws InterruptedException {
        String itemName = "ASUS TUF Gaming A15 FA507 2024";
        String discountValue = "15";
        startPage = new StartPage(driver);
        startPage.acceptCookies();
        startPage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        //startPage.waitForLoadingStartPage();
        Thread.sleep(1000);
        assertTrue(startPage.headerIsVisible());
        startPage.searchItemWithName(itemName);
        itemsListPage = new ItemsListPage(driver);
        itemsListPage.waitForLoadingItemsListPage();
        itemsListPage.waitForAllVisibilityResultItemList();
        assertFalse(itemsListPage.namesAreNotEmpty());
        itemsListPage.chooseOneItem(itemName);
        itemPage = new ItemPage(driver);
        itemPage.clickPriceAlertButton();
        wishPriceSetupPage = new WishPriceSetupPage(driver);
        wishPriceSetupPage.discount15Click(discountValue);
        wishPriceSetupPage.clickPriceAlertSetupButton();
        successWishPriceSetupPage = new SuccessWishPriceSetupPage(driver);
        assertTrue(successWishPriceSetupPage.successAlertIsVisible());
        assertTrue(successWishPriceSetupPage.itemIsEquals(itemName));
        successWishPriceSetupPage.clickAgreeButton();
    }
}
