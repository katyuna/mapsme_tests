package mapsme.po;


import com.github.javafaker.Faker;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static io.appium.java_client.touch.offset.PointOption.point;

public class SearchBottomSheet {
    private AndroidDriver driver;

    public SearchBottomSheet() {
    }

    public SearchBottomSheet(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    //Search categories sheet header
    @AndroidFindBy(xpath = ".//android.view.View[@resource-id='search_categories_container']")
    private WebElement searchCategoriesConteiner;

    @AndroidFindBy(xpath = ".//android.view.View[@content-desc='search icon']")
    private WebElement searchIcon;

    //[Х]
    //@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.widget.Button")
    @AndroidFindBy(xpath = ".//android.view.View[@content-desc='closeButton']")
    private WebElement closeButton;

    //Search field
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.widget.EditText")
    private WebElement searchField;

    //Category Icons
    @AndroidFindBy(xpath = "(.//android.view.View[@content-desc='category icon'])[1]")
    private WebElement categoryIcon1;

    @AndroidFindBy(xpath = "(.//android.view.View[@content-desc='category icon'])[4]")
    private WebElement categoryIcon2;

    //Cancel
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View")
    private WebElement cancelButton;

    //First search result
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[3]/android.view.View[1]")
    private WebElement firstSearchResult;

    //First search result name
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[2]")
    private WebElement firstSearchResultName;

    //First search history
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View[2]")
    private WebElement firstSearchHistory;

    //"Unfortunately we didn't find anything" text
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[3]")
    private WebElement noResultsText;

    //Is Search categories sheet header displayed
    public boolean isSearchCategoriesConteiner() {
        return searchCategoriesConteiner.isDisplayed();
    }

    //Is Search Icon displayed
    public boolean isSearchIcon() {
        return searchIcon.isDisplayed();
    }

    //Is close button
    public boolean isCloseButton() {
        return closeButton.isDisplayed();
    }

    //Is category icon 1
    public boolean isCategoryIcon() {
        return categoryIcon1.isDisplayed();
    }

    //Is Search results displayed
    public boolean isSearchResult() {
        return firstSearchResult.isDisplayed();
    }

    //Is Search history displayed
    public boolean isSearchHistory() {
        return firstSearchHistory.isDisplayed();
    }

    //Click search icon
    public void clickSearchIcon() {
        this.searchIcon.click();
    }

    //Enter search
    public void setSearch(String search) {
        this.searchField.sendKeys(search);
    }

    //Click search result
    public void clickSearchResult() {
        this.firstSearchResult.click();
    }

    //Click Cancel button
    public void clickCancelButton() {
        this.cancelButton.click();
    }

    //Close Search sheet by click [x]
    public void clickCloseButton() {
        this.closeButton.click();
    }

    //Get text for search history result
    public String searchHistoryGetText(){
        String searchHistoryText = firstSearchHistory.getAttribute("text");
        return searchHistoryText;
    }

    //Get search field text
    public String searchFieldGetText(){
        String searchFieldText = searchField.getAttribute("text");
        return searchFieldText;
    }

    //Get first search result name
    public String firstSearchResultNameGetText(){
        String firstSearchFieldName = firstSearchResultName.getAttribute("text");
        return firstSearchFieldName;
    }

    //Get no results text
    public String noResultsGetText(){
        String noResultText = noResultsText.getAttribute("text");
        return noResultText;
    }

    public String noResultString (){
        return "Unfortunately we didn't find anything";
    }


    //Generate test data
        public String generateCityName (){
            Faker faker = new Faker();
            String cityName = faker.address().cityName();
            return cityName;
    }
}
