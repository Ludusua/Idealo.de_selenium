import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishPriceSetupPage extends BasePage {
    public WishPriceSetupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(text(),'spare 15 %')]")
    private WebElement discount15;
    @FindBy(xpath = "//button[contains(text(),'spare 10 %')]")
    private WebElement discount10;

    @FindBy(xpath = "//*[@class=\"sc-eqUAAy cHxsyP\"]")
    private List<WebElement> discountButtons;

    public void discount15Click(String discountValue) {
        getWait().forAllVisibility(discountButtons);
        for (WebElement button : discountButtons) {
            if (button.getText().contains(discountValue)) {
                button.click();
                break;
            }
        }
    }
}
