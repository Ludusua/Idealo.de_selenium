import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends BasePage{
    public CategoryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1")
    private WebElement categoryTitle;

    public boolean getCategoryName(String name){
        getWait().forVisibility(categoryTitle);
        return categoryTitle.getText().contains(name);
    }
}
