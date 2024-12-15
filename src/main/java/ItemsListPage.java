import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemsListPage extends BasePage {
    public ItemsListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    private WebElement categoryTitle;
    @FindBy(xpath = "//*[@data-testid='resultList']")
    private WebElement resultList;
    @FindBy(xpath = "//*[@data-testid='resultItem']")
    private List<WebElement> resultItemList;
    @FindBy(xpath = "//*[@class='sr-productSummary__title_f5flP']")
    private List<WebElement> itemsNameList;
    @FindBy(xpath = "//button[@data-testid='grid-button']")
    private WebElement gridViewButton;
    @FindBy(xpath = "//button[@data-testid='list-button']")
    private WebElement listViewButton;

    public void waitForLoadingItemsListPage() {
        getWait().forVisibility(categoryTitle);
        assertTrue(categoryTitle.isDisplayed());
        getWait().forVisibility(resultList);
        assertTrue(resultList.isDisplayed());
    }

    public void chooseGridView() {
        getWait().forVisibility(gridViewButton);
        gridViewButton.click();
    }

    public void chooseListView() {
        getWait().forVisibility(listViewButton);
        listViewButton.click();
    }

    public void waitForAllVisibilityResultItemList() {
        getWait().forAllVisibility(resultItemList);
        System.out.println(resultItemList.size());
    }

    public boolean namesAreNotEmpty() {
        boolean isEmpty = false;
        for (WebElement itemName : itemsNameList) {
            if (itemName.getText().isEmpty()) {
                isEmpty = true;
                break;
            }
        }
        return isEmpty;
    }
    public boolean namesContainsItemName(String nameOfElement) {
        boolean containsName = true;
        for (WebElement itemName : itemsNameList) {
            if (!itemName.getText().contains(nameOfElement)) {
                containsName = false;
                break;
            }
        }
        return containsName;
    }
    public void chooseOneItem(String nameOfElement) {
        for (WebElement itemName : itemsNameList) {
            if (itemName.getText().contains(nameOfElement)) {
                itemName.click();
                break;
            }
        }
    }
}
