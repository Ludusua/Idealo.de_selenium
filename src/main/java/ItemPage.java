import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ItemPage extends BasePage {
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = " //div[@class='favouritesWrapper show-for-large']//span//*[name()='svg']//*[name()='path' and contains(@d,'M21.317,3.')]")
    private WebElement addToFavoriteButton;

    public void clickOnFavoriteButton() {
        getWait().forVisibility(addToFavoriteButton);
        addToFavoriteButton.click();
    }
}
