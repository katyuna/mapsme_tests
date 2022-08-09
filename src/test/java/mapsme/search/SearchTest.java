package mapsme.search;

import io.qameta.allure.Issue;
import mapsme.BaseTest;

import io.qameta.allure.Step;
import jdk.jfr.Description;
import mapsme.Steps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import mapsme.po.MainScreen;
import mapsme.po.PlaсePage;
import mapsme.po.SearchBottomSheet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BaseTest {
    @Test
    @Order(1)
    @Issue("1014, 1034, 1035")
    @DisplayName("Search via search field in Search bottom sheet")
    @Description("The object has been found via search field in Search bottom sheet." +
            "Search result is clickable." +
            "Search results can be clear. " +
            "Search results can be cancel.")
    public void testSearchViaSearchFieldOnSearchBottomSheet() {
        Steps.waitSearchButton();
        Steps.clickSearchButton();
        Steps.clickSearchField();
        Steps.setSearchString();
        Steps.waitSearchResults();
        Steps.clickSearchResult();
        Steps.closePlacePageFromSearchResults();
        Steps.clickSearchField();
        Steps.clearSearchFieldByPressX();
        Steps.clickSearchCancel();
        Steps.closeSearchBottomSheetByX();
    }
}

