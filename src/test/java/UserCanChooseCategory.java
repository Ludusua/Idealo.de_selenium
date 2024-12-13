import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserCanChooseCategory extends BaseTest {
    StartPage startPage;
    CategoryPage categoryPage;

    @Test
    public void clickOnCategory() {
        String categoryName ="Baby & Kind";
        startPage = new StartPage(driver);
        startPage.acceptCookies();
        startPage.moveToElementAndClick(categoryName);
        categoryPage = new CategoryPage(driver);
        assertTrue(categoryPage.getCategoryName(categoryName));
    }
}
