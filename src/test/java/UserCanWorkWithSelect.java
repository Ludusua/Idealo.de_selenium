import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanWorkWithSelect extends BaseTest{
    LoginPage loginPage;
    StartPage startPage;
    CategoryPage categoryPage;
    SubCategoryPage subCategoryPage;
    ItemsListPage itemsListPage;

    @Test
    public void chooseOneItemFromCategoryAndAddToFavorite() throws InterruptedException {
        String category = "Auto & Motorrad";
        String oneCategoryName = "Räder & Reifen";
        String subCategoryName = "Sommerreifen";
        String individualCategoryName = "Goodyear";
        String itemName = "Animal Crossing: New Leaf - Welcome amiibo (3DS)";
        startPage = new StartPage(driver);
        startPage.acceptCookies();
        startPage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        //startPage.feedbackButtonIsVisible();
        Thread.sleep(1000);
       // startPage.waitForLoadingStartPage();
        assertTrue(startPage.headerIsVisible());
        startPage.moveToElementAndClick(category);
        categoryPage = new CategoryPage(driver);
        assertTrue(categoryPage.getCategoryName(category));
        categoryPage.clickAllCategoryButton();
        categoryPage.moveToElementAndClick(oneCategoryName);
        subCategoryPage = new SubCategoryPage(driver);
        subCategoryPage.clickAllCategoryButton();
        subCategoryPage.moveToElementAndClickOneCategoryItem(subCategoryName, individualCategoryName);
        itemsListPage = new ItemsListPage(driver);
        itemsListPage.waitForLoadingItemsListPage();
//        itemsListPage.chooseListView();
//        itemsListPage.waitForAllVisibilityResultItemList();
//        assertFalse(itemsListPage.namesAreNotEmpty());
//        assertTrue(itemsListPage.namesContainsItemName(individualCategoryName));
//        itemsListPage.chooseOneItemAddToFavorite(itemName);
    }
}
