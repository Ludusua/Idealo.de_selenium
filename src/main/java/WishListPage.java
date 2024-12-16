import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends BasePage {
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='wishlist-item wishlist-item-list']")
    private List<WebElement> itemsList;
    @FindBy(xpath = "//*[@class='title']")
    private List<WebElement> itemNames;
    @FindBy(xpath = "//button[contains(text(),'Produkt entfernen')]")
    private WebElement deleteFromFavoriteButton;
    @FindBy(xpath = "//h1[contains(text(),'Mein Merkzettel')]")
    private WebElement wishListTitle;

    public void itemAvailableAndDelete(String itemName) {
        for (WebElement name : itemNames) {
            if (name.getText().equals(itemName)) {
                deleteFromFavoriteButton.click();
                break;
            }
        }
    }

    public boolean itemAvailable(String itemName){
        boolean isAvailable = false;
        for (WebElement name : itemNames) {
            if (name.getText().equals(itemName)) {
                isAvailable =true;
                break;
            }
        }
        return isAvailable;
    }
}
