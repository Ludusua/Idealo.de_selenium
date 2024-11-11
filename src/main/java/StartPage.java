import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends BasePage{
    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='myidealo-button']")
    private WebElement loginTitle;
    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    WebElement cookies;
    public void clickOnCookies(){
        getWait().forVisibility(cookies);
        cookies.click();

    }

    public void clickOnLoginTitle(){
        getWait().forVisibility(loginTitle);
        loginTitle.click();
    }

}
