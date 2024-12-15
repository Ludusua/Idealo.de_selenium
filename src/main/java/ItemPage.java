import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ItemPage extends BasePage {
    public ItemPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = " //div[@class='favouritesWrapper show-for-large']//span//*[name()='svg']//*[name()='path' and contains(@d,'M21.317,3.')]")
    private WebElement addToFavoriteButton;
    public void switchToFrame(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.cssSelector("iframe[src*='account.idealo.de']")
        ));
    }
    public void clickOnFavoriteButton() {
        getWait().forVisibility(addToFavoriteButton);
        addToFavoriteButton.click();
    }
}
