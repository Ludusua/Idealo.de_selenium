import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartPage extends BasePage {
    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='myidealo-button']")
    private WebElement loginTitle;
    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    WebElement cookies;

    public void clickOnCookies() {
        getWait().forVisibility(cookies);
        cookies.click();

    }

    public void acceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='usercentrics-cmp-ui']")));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement acceptButton = shadowRoot.findElement(By.cssSelector("[aria-label='Annehmen']"));
        acceptButton.click();
    }

    public void clickOnLoginTitle() {
        getWait().forVisibility(loginTitle);
        loginTitle.click();
    }

}
