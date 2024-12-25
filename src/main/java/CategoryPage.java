import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryPage extends BasePage {
    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    private WebElement categoryTitle;
    @FindBy(xpath = "//*[@data-testid='category-grid-item']")
    private List<WebElement> categoryGridItem;
    @FindBy(xpath = "//*[@data-testid='category-grid-item']//span")
    private List<WebElement> categoryGridItemsName;
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

    public boolean getCategoryName(String name) {
        getWait().forVisibility(categoryTitle);
        return categoryTitle.getText().contains(name);
    }

    public void clickAllCategoryButton() {
        getWait().forVisibility(allCategoryButton);
        allCategoryButton.click();
    }
}
