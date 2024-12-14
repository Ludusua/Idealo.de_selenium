import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SubCategoryPage extends BasePage {
    public SubCategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    private WebElement categoryTitle;
    @FindBy(xpath = "//*[@data-testid='category-grid-item']")
    private List<WebElement> categoryGridItem;
    @FindBy(xpath = "//*[@data-testid='category-grid-item']//span")
    private List<WebElement> categoryGridItemsName;
    @FindBy(xpath = "//*[@data-testid='category-grid-item']//a")
    private List<WebElement> subCategoryGridItemsName;
    @FindBy(xpath = "//button[normalize-space()='Alle Kategorien']")
    private WebElement allCategoryButton;

    public void moveToElementAndClick(String name) {
        List<WebElement> elements = categoryGridItemsName;
        getWait().forAllVisibility(elements);
        for (WebElement element : elements) {
            if (element.getText().contains(name)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(element).click().perform();
                break;
            }
        }
    }

    public void moveToElementAndClickOneCategoryItem(String nameOfCategory, String nameOfSubCategory) {
        getWait().forAllVisibility(categoryGridItemsName);
        for (WebElement element : categoryGridItemsName) {
            if (element.getText().contains(nameOfCategory)) {
                getWait().forAllVisibility(subCategoryGridItemsName);
                for (WebElement element1 : subCategoryGridItemsName) {
                    if (element1.getText().equals(nameOfSubCategory)) {
                        Actions actions = new Actions(driver);
                        actions.moveToElement(element).perform();
                        getWait().forClickable(element1);
                        element1.click();
                        break;
                    }
                }
                break;
            }
        }
    }

    public boolean getCategoryName(String name) {
        getWait().forVisibility(categoryTitle);
        return categoryTitle.getText().contains(name);
    }

    public void clickAllCategoryButton() {
        getWait().forVisibility(allCategoryButton);
        allCategoryButton.click();
    }
}
