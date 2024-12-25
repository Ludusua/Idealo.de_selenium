import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CookiesPage extends BasePage{
    public CookiesPage(WebDriver driver) {
        super(driver);
    }
   // @FindBy(xpath = "//*[src='https://web.cmp.usercentrics.eu/cdcs/v/1.0.0/index.html']")
   // public WebElement iframe;
    @FindBy(xpath = "//*[id=\"uc-cmp-description\"]")
    public WebElement dialogWindow;
    @FindBy(xpath = "//*[@aria-label='Annehmen']")
    WebElement cookiesAccept;

    public void waitForLoadingCookiesPage(){
        getWait().forVisibility(dialogWindow);
        assertTrue(dialogWindow.isDisplayed());
        getWait().forVisibility(cookiesAccept);
        assertTrue(cookiesAccept.isDisplayed());
    }

}
