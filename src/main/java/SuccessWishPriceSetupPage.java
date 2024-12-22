import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessWishPriceSetupPage extends BasePage {
    public SuccessWishPriceSetupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[contains(text(),'Dein Preiswecker wurde gestellt')]")
    private WebElement successAlertSetupTitle;
    @FindBy(xpath = "//*[@class='cards-productName']")
    private WebElement successAddItemName;
    @FindBy(xpath = "//button[contains(text(),'Okay, verstanden')]")
    private WebElement agreeButton;
    public boolean successAlertIsVisible() {
        getWait().forVisibility(successAlertSetupTitle);
        return successAlertSetupTitle.isDisplayed();
    }

    public boolean itemIsEquals(String itemName) {
        getWait().forVisibility(successAddItemName);
        return successAddItemName.getText().equals(itemName);
    }

    public void clickAgreeButton() {
        getWait().forClickable(agreeButton);
        agreeButton.click();
    }

}
