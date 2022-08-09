package mapsme;

import io.qameta.allure.Step;
import mapsme.po.MainScreen;
import mapsme.po.PlaсePage;
import mapsme.po.SearchBottomSheet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Steps extends BaseTest {
    //Create screens objects
    static MainScreen mainScreen = new MainScreen(driver);
    static SearchBottomSheet searchBottomSheet = new SearchBottomSheet(driver);

    static PlaсePage plaсePage = new PlaсePage(driver);

    //Main Screen
    @Step("Wait search button")
    public static void waitSearchButton() {
        mainScreen.isSearchButton();
        boolean searchButtonIsDisplayed = mainScreen.isSearchButton();
        assertTrue(searchButtonIsDisplayed);
    }

    @Step("Click search button")
    public static void clickSearchButton() {
        mainScreen.clickSearchButton();
        assertTrue(searchBottomSheet.isSearchIcon());
    }

    //Search Bottom Sheet
    @Step("Assert search icon")
    public static void assertSearchIcon() {
        assertTrue(searchBottomSheet.isSearchIcon());
    }

    @Step("Assert close button")
    public static void assertCloseButton() {
        assertTrue(searchBottomSheet.isCloseButton());
    }

    @Step("Assert category icon")
    public static void assertCategoryIcon() {
        assertTrue(searchBottomSheet.isCategoryIcon());
    }

    @Step("Click search field")
    public static void clickSearchField() {
        searchBottomSheet.clickSearchIcon();
        //assert что развернулся шит
    }

    @Step("Set search string")
    public static void setSearchString() {
        searchBottomSheet.setSearch("McDonalds");
        //assert что заполнилось
    }

    @Step("Wait search results")
    public static void waitSearchResults() {
        searchBottomSheet.isSearchResult();
        boolean searchResultIsDisplayed = searchBottomSheet.isSearchResult();
        assertTrue(searchResultIsDisplayed);
    }

    @Step("Click search result and assert place page opened")
    public static void clickSearchResult() {
        searchBottomSheet.clickSearchResult();
        boolean placePageIsDisplayed = plaсePage.isMarkerCoordinatesIcon();
        assertTrue(placePageIsDisplayed);
    }

    @Step("Close place page by back arrow and assert back to the search results")
    public static void closePlacePageFromSearchResults() {
        plaсePage.clickBackArrow();
        assertTrue(searchBottomSheet.isSearchResult());
    }

    @Step("Clear search field by press [X]")
    public static void clearSearchFieldByPressX() {
        searchBottomSheet.clickCloseButton();
        //assert что поле пустое
    }

    @Step("Click Cancel and assert back to the search bottom sheet")
    public static void clickSearchCancel() {
        searchBottomSheet.clickCancelButton();
        assertTrue(searchBottomSheet.isCategoryIcon());
    }

    @Step("Close search button and assert back to the main screen")
    public static void closeSearchBottomSheetByX() {
        searchBottomSheet.clickCloseButton();
        assertTrue(mainScreen.isSearchButton());
    }
}
