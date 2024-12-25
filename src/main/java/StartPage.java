import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StartPage extends BasePage {
    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='myidealo-button-wrapper']//*[text()='Anmelden']")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    private WebElement cookies;
    @FindBy(xpath = "//iframe[contains(@src, 'idealo.de')]")
    private WebElement iframe;

    @FindBy(xpath = "//span[contains(text(),'Merkzettel')]")
    private WebElement wishlistButton;
    @FindBy(xpath = "//*[@id='IFeedbackButton']")
    private WebElement feedbackButton;
    @FindBy(xpath = "//*[@class='ac-login-form']")
    private WebElement loginForm;
    @FindBy(css = "div[class$='category-bar-categories-no-swipe']")
    private List<WebElement> labelsList;
    @FindBy(xpath = "//section[@aria-label='Kategorieleiste']")

    private WebElement header;
    @FindBy(xpath = "//*[@id='i-search-input']")
    private WebElement searchInputField;

    public void clickLoginButton() {
        getWait().forClickable(loginButton);
        loginButton.click();
    }

    public void waitForLoadingStartPage() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.urlToBe("https://www.idealo.de/"));
//        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
//        wait.until(ExpectedConditions.visibilityOf(feedbackButton));
        //getWait().forAllVisibility(labelsList);
        assertTrue(feedbackButton.isDisplayed());
    }


    public void searchItemWithName(String item) {
        getWait().forVisibility(searchInputField);
        searchInputField.sendKeys(item + Keys.ENTER);
    }

    public boolean headerIsVisible() {
        getWait().forVisibility(header);
        return header.isDisplayed();
    }

    public void clickWishlistButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(wishlistButton));
        wishlistButton.click();
    }

    public boolean feedbackButtonIsVisible() {
        getWait().forClickable(feedbackButton);
        return feedbackButton.isDisplayed();
    }

    public void switchToFrame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.cssSelector("iframe[src*='account.idealo.de']")
        ));
    }

    public void acceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='usercentrics-cmp-ui']")));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement acceptButton = shadowRoot.findElement(By.cssSelector("[aria-label='Annehmen']"));
        acceptButton.click();
    }


    public void moveToElementAndClick(String name) {
        getWait().forAllVisibility(labelsList);
        for (WebElement element : labelsList) {
            if (element.getText().contains(name)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(element).click().perform();
                break;
            }
        }
    }

}
