import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanChooseCategory extends BaseTest {
    LoginPage loginPage;
    StartPage startPage;
    CategoryPage categoryPage;
    SubCategoryPage subCategoryPage;
    ItemsListPage itemsListPage;
    ItemPage itemPage;

    @Test
    public void clickOnCategory() {
        String categoryName = "Baby & Kind";
        startPage = new StartPage(driver);
        startPage.acceptCookies();
        startPage.moveToElementAndClick(categoryName);
        categoryPage = new CategoryPage(driver);
        assertTrue(categoryPage.getCategoryName(categoryName));
    }

    @Test
    public void chooseOneItemFromCategoryAndAddToFavorite()  {
        String category = "Gaming & Spielen";
        String oneCategoryName = "Video- & Computerspiele";
        String subCategoryName = "Videospiele";
        String individualCategoryName = "Animal Crossing";
        String itemName="Animal Crossing: New Leaf (3DS)";
        startPage = new StartPage(driver);
        startPage.acceptCookies();
        startPage.clickLoginButton();
        loginPage = new LoginPage(driver);
        loginPage.login(VALID_EMAIL, VALID_PASSWORD);
        startPage = new StartPage(driver);
        startPage.waitForLoadingStartPage();
        startPage.moveToElementAndClick(category);
        categoryPage = new CategoryPage(driver);
        assertTrue(categoryPage.getCategoryName(category));
        categoryPage.clickAllCategoryButton();
        categoryPage.moveToElementAndClick(oneCategoryName);
        subCategoryPage = new SubCategoryPage(driver);
        subCategoryPage.moveToElementAndClickOneCategoryItem(subCategoryName, individualCategoryName);
        itemsListPage = new ItemsListPage(driver);
        itemsListPage.waitForLoadingItemsListPage();
        itemsListPage.chooseListView();
        itemsListPage.waitForAllVisibilityResultItemList();
        assertFalse(itemsListPage.namesAreNotEmpty());
        assertTrue(itemsListPage.namesContainsItemName(individualCategoryName));
        itemsListPage.chooseOneItem(itemName);
        itemPage = new ItemPage(driver);
        itemPage.clickOnFavoriteButton();
//        itemPage.switchToFrame();
//        loginPage = new LoginPage(driver);
//        loginPage.waitForLoadingLoginPage();
//        loginPage.setEmailInputField(email);
//        loginPage.setPasswordInputField(password);
//        loginPage.clickOnLoginButton();
//        Thread.sleep(3000);
    }
}
