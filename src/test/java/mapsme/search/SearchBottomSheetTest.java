package mapsme.search;

import io.qameta.allure.Attachment;
import io.qameta.allure.Issue;
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
    @Issue("https://app.qase.io/project/MAPS?view=1&suite=161&case=1010")
    @DisplayName("Open and close Search bottom sheet")
    @Description("The search bottom sheet has been opened and closed by tap on [x]")
    @Attachment(value = "Page screenshot", type = "image/png")
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
        assertTrue(searchButtonIsDisplayed);
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

    @Step("Assert category icon")
    public void assertCategoryIcon() {
        assertTrue(searchBottomSheet.isCategoryIcon());
    }

    @Step("Close search button")
    public void closeSearchButton() {
        searchBottomSheet.clickCloseButton();
    }
}
