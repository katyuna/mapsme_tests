package mapsme.search;

import mapsme.BaseTest;

import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import mapsme.po.MainScreen;
import mapsme.po.PlaсePage;
import mapsme.po.SearchBottomSheet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BaseTest {
    //Create screens objects
    MainScreen mainScreen = new MainScreen(driver);
    SearchBottomSheet searchBottomSheet = new SearchBottomSheet(driver);
    PlaсePage plaсePage = new PlaсePage(driver);

    @Test
    @Order(1)
    @DisplayName("Search via search field in Search bottom sheet")
    @Description("The object has been found via search field in Search bottom sheet and search result is clickable")
    public void testSearchViaSearchFieldOnSearchBottomSheet() {
        waitSearchButton();
        openSearchSheet();
        setSearchString();
        assertSearchResults();
        clickSearchResult();
    }

    @Step("Wait search button")
    public void waitSearchButton() {
        mainScreen.isSearchButton();
        boolean searchButtonIsDisplayed = mainScreen.isSearchButton();
        assertTrue(searchButtonIsDisplayed, "Error: route button doesn't displays");
    }

    @Step("Click search button and open search sheet")
    public void openSearchSheet() {
        mainScreen.clickSearchButton();
        boolean searchSheetIsDisplayed = searchBottomSheet.isSearchIcon();
        assertTrue(searchSheetIsDisplayed);
    }

    @Step("Set search string")
    public void setSearchString() {
        searchBottomSheet.clickSearchIcon();
        searchBottomSheet.setSearch("McDonalds");
    }

    @Step("Wait and assert search results")
    public void assertSearchResults() {
        searchBottomSheet.isSearchResult();
        boolean searchResultIsDisplayed = searchBottomSheet.isSearchResult();
        assertTrue(searchResultIsDisplayed);
    }

    @Step("Click search result and assert place page opened")
    public void clickSearchResult() {
        searchBottomSheet.clickSearchResult();
        boolean placePageIsDisplayed = plaсePage.isMarkerCoordinatesIcon();
        assertTrue(placePageIsDisplayed);
    }

    @Step("Close search sheet")
    public void closeSearchBottomSheet() {
        searchBottomSheet.clickCloseButton();
        boolean searchButtonIsDisplayed = mainScreen.isSearchButton();
        assertTrue(searchButtonIsDisplayed, "Error: route button doesn't displays");
    }

    @Step("Close place page by back arrow")
    public void closePlacePage() {
        plaсePage.clickBackArrow();
    }

}

