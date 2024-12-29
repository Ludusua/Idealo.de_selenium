import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemsListPage extends BasePage {
    public ItemsListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    private WebElement categoryTitle;
    @FindBy(xpath = "//*[@data-testid='resultList']")
    private WebElement resultList;
    @FindBy(xpath = "//*[@data-testid='resultItem']")
    private List<WebElement> resultItemList;
    @FindBy(xpath = "//*[@class=\"wishlistHeart\"]")
    private WebElement addFavoriteButton;
    @FindBy(xpath = "//*[@class='sr-productSummary__title_f5flP']")
    private List<WebElement> itemsNameList;
    @FindBy(xpath = "//button[@data-testid='grid-button']")
    private WebElement gridViewButton;
    @FindBy(xpath = "//button[@data-testid='list-button']")
    private WebElement listViewButton;
    @FindBy(xpath = "//*[@id='Reifenbreite (mm)']")
    private WebElement dropdownReifenbreite;
    @FindBy(xpath = "//*[@id='Reifenquerschnitt (%)']")
    private WebElement dropdownReifenquerschnitt;
    @FindBy(xpath = "//*[@id='Felgendurchmesser']")
    private WebElement dropdownFelgendurchmesser;
    @FindBy(xpath = "//*[@id='Tragfähigkeitsindex']")
    private WebElement dropdownTragfähigkeitsindex;
    @FindBy(xpath = "//*[@id='Geschwindigkeitsindex']")
    private WebElement dropdownGeschwindigkeitsindex;

    public void chooseReifenbreite(String text) {
        selectWith(dropdownReifenbreite, text);
    }

    public void chooseReifenquerschnitt(String text) {
        selectWith(dropdownReifenquerschnitt, text);
    }

    public void chooseFelgendurchmesser(String text) {
        selectWith(dropdownFelgendurchmesser, text);
    }

    public void chooseTragfähigkeitsindex(String text) {
        selectWith(dropdownTragfähigkeitsindex, text);
    }

    public void chooseGeschwindigkeitsindex(String text) {
        selectWith(dropdownGeschwindigkeitsindex, text);
    }

    public void setWheelData(String reifenbreite, String reifenquerschnitt, String felgendurchmesser, String tragfähigkeitsindex, String geschwindigkeitsindex) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        getWait().forVisibility(dropdownReifenbreite);
        dropdownReifenbreite.click();
        selectWith(dropdownReifenbreite, reifenbreite);
        wait.until(ExpectedConditions.textToBePresentInElement(dropdownReifenbreite, reifenbreite));
        Thread.sleep(1000);
        getWait().forVisibility(dropdownReifenquerschnitt);
        dropdownReifenquerschnitt.click();
        selectWith(dropdownReifenquerschnitt, reifenquerschnitt);
        wait.until(ExpectedConditions.textToBePresentInElement(dropdownReifenquerschnitt, reifenquerschnitt));
        Thread.sleep(1000);
        getWait().forVisibility(dropdownFelgendurchmesser);
        dropdownFelgendurchmesser.click();
        selectWith(dropdownFelgendurchmesser, felgendurchmesser);
        wait.until(ExpectedConditions.textToBePresentInElement(dropdownFelgendurchmesser, felgendurchmesser));
        Thread.sleep(1000);
        getWait().forVisibility(dropdownTragfähigkeitsindex);
        dropdownTragfähigkeitsindex.click();
        selectWith(dropdownTragfähigkeitsindex, tragfähigkeitsindex);
        wait.until(ExpectedConditions.textToBePresentInElement(dropdownTragfähigkeitsindex, tragfähigkeitsindex));
        Thread.sleep(1000);
        getWait().forVisibility(dropdownGeschwindigkeitsindex);
        dropdownGeschwindigkeitsindex.click();
        selectWith(dropdownGeschwindigkeitsindex, geschwindigkeitsindex);
        wait.until(ExpectedConditions.textToBePresentInElement(dropdownGeschwindigkeitsindex, geschwindigkeitsindex));
    }

    public void waitForLoadingItemsListPage() {
        getWait().forVisibility(categoryTitle);
        assertTrue(categoryTitle.isDisplayed());
        getWait().forVisibility(resultList);
        assertTrue(resultList.isDisplayed());
    }

    public void chooseGridView() {
        getWait().forVisibility(gridViewButton);
        gridViewButton.click();
    }

    public void chooseListView() {
        getWait().forVisibility(listViewButton);
        listViewButton.click();
    }

    public void waitForAllVisibilityResultItemList() {
        getWait().forAllVisibility(resultItemList);
        System.out.println(resultItemList.size());
    }

    public boolean namesAreNotEmpty() {
        boolean isEmpty = false;
        for (WebElement itemName : itemsNameList) {
            if (itemName.getText().isEmpty()) {
                isEmpty = true;
                break;
            }
        }
        return isEmpty;
    }

    public boolean namesContainsItemName(String nameOfElement) {
        boolean containsName = true;
        for (WebElement itemName : itemsNameList) {
            if (!itemName.getText().contains(nameOfElement)) {
                containsName = false;
                break;
            }
        }
        return containsName;
    }

    public void chooseOneItem(String nameOfElement) {
        for (WebElement itemName : itemsNameList) {
            if (itemName.getText().contains(nameOfElement)) {
                itemName.click();
                break;
            }
        }
    }

    public void chooseOneItemAddToFavorite(String nameOfElement) {
        for (WebElement item : resultItemList) {
            if (item.getText().contains(nameOfElement)) {
                WebElement addToFavorite = item.findElement(By.xpath(".//*[@data-testid=\"wishlist-heart\"]"));//[data-testid='wishlist-heart']
                addToFavorite.click();
                break;
            }
        }
    }
}
