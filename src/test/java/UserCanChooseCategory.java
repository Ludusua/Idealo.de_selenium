import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanChooseCategory extends BaseTest {
    StartPage startPage;
    CategoryPage categoryPage;
    SubCategoryPage subCategoryPage;
    ItemsListPage itemsListPage;

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
    public void chooseOneItemFromCategory() {
        String category = "Gaming & Spielen";
        String oneCategoryName = "Video- & Computerspiele";
        String subCategoryName = "Videospiele";
        String individualCategoryName = "Animal Crossing";
        startPage = new StartPage(driver);
        startPage.acceptCookies();
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
    }
}
