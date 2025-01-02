import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    @FindBy(xpath = "//*[@class='wishlistHeart']")
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


    public void setDropdownReifenbreite(String reifenbreite) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Select select = new Select(dropdownReifenbreite);
        getWait().forVisibility(dropdownReifenbreite);
        dropdownReifenbreite.click();
        selectWith(dropdownReifenbreite, reifenbreite);
        wait.until(driver -> select.getFirstSelectedOption().getText().equals(reifenbreite));
    }

    public void setDropdownReifenquerschnitt(String reifenquerschnitt) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Select select = new Select(dropdownReifenquerschnitt);
        getWait().forVisibility(dropdownReifenquerschnitt);
        dropdownReifenquerschnitt.click();
        selectWith(dropdownReifenquerschnitt, reifenquerschnitt);
        wait.until(driver -> select.getFirstSelectedOption().getText().equals(reifenquerschnitt));
    }

    public void setDropdownFelgendurchmesser(String felgendurchmesser) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Select select = new Select(dropdownFelgendurchmesser);
        getWait().forVisibility(dropdownFelgendurchmesser);
        dropdownFelgendurchmesser.click();
        selectWith(dropdownFelgendurchmesser, felgendurchmesser);
        wait.until(driver -> select.getFirstSelectedOption().getText().equals(felgendurchmesser));
    }

    public void setDropdownTragfähigkeitsindex(String tragfähigkeitsindex) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Select select = new Select(dropdownTragfähigkeitsindex);
        getWait().forVisibility(dropdownTragfähigkeitsindex);
        dropdownTragfähigkeitsindex.click();
        selectWith(dropdownTragfähigkeitsindex, tragfähigkeitsindex);
        wait.until(driver -> select.getFirstSelectedOption().getText().equals(tragfähigkeitsindex));
    }

    public void setDropdownGeschwindigkeitsindex(String geschwindigkeitsindex) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Select select = new Select(dropdownGeschwindigkeitsindex);
        getWait().forVisibility(dropdownGeschwindigkeitsindex);
        dropdownGeschwindigkeitsindex.click();
        selectWith(dropdownGeschwindigkeitsindex, geschwindigkeitsindex);
        wait.until(driver -> select.getFirstSelectedOption().getText().equals(geschwindigkeitsindex));
    }

    public void setWheelData1(String reifenbreite, String reifenquerschnitt, String felgendurchmesser, String tragfähigkeitsindex, String geschwindigkeitsindex) {
        setDropdownReifenbreite(reifenbreite);
        setDropdownReifenquerschnitt(reifenquerschnitt);
        setDropdownFelgendurchmesser(felgendurchmesser);
        setDropdownTragfähigkeitsindex(tragfähigkeitsindex);
        setDropdownGeschwindigkeitsindex(geschwindigkeitsindex);
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
                WebElement addToFavorite = item.findElement(By.xpath(".//*[@data-testid='wishlist-heart']"));
                addToFavorite.click();
                break;
            }
        }
    }
}
