package mapsme.search;

import io.qameta.allure.Step;
import jdk.jfr.Description;
import mapsme.BaseTest;
import mapsme.po.MainScreen;
import mapsme.po.SearchBottomSheet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchBottomSheetTest extends BaseTest {
    MainScreen mainScreen = new MainScreen(driver);
    SearchBottomSheet searchBottomSheet = new SearchBottomSheet(driver);

    @Test
    @Order(1)
    @DisplayName("Open and close Search bottom sheet")
    @Description("The search bottom sheet has been opened and closed by tap on [x]")
    public void testOpenAndCloseSearchBottomSheet() {
        waitSearchButton();
        clickSearchButton();
        assertSearchIcon();
        assertCloseButton();
        assertCategoryIcon();
        closeSearchButton();
    }

    @Step("Wait search button")
    public void waitSearchButton() {
        mainScreen.isSearchButton();
        boolean searchButtonIsDisplayed = mainScreen.isSearchButton();
        assertTrue(searchButtonIsDisplayed, "Error: route button doesn't displays");
    }

    @Step("Click search button")
    public void clickSearchButton() {
        mainScreen.clickSearchButton();
    }

    @Step("Assert search icon")
    public void assertSearchIcon() {
        assertTrue(searchBottomSheet.isSearchIcon());
    }

    @Step("Assert close button")
    public void assertCloseButton() {
        assertTrue(searchBottomSheet.isCloseButton());
    }

    @Step("Assert category nicon")
    public void assertCategoryIcon() {
        assertTrue(searchBottomSheet.isCategoryIcon());
    }

    @Step("Close search button")
    public void closeSearchButton() {
        searchBottomSheet.clickCloseButton();
    }
}
