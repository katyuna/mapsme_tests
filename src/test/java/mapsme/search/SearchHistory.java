package mapsme.search;

import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class SearchHistory extends BaseTest{
    @Test
    @Order(1)
    @Issue("1016")
    @DisplayName("Search history displayed after repeated search")
    @Description("Search history displayed after repeated search." +
            "Desired object displays in search history.")
    public void testSearchViaSearchFieldOnSearchBottomSheet() {
        Steps.waitSearchButton();
        Steps.clickSearchButton();
        Steps.clickSearchField();
        Steps.setSearchString();
        Steps.waitSearchResults();
        Steps.clickSearchResult();
        Steps.closePlacePageFromSearchResults();
        Steps.clickSearchCancel();
        Steps.closeSearchBottomSheetByX();
    }
}
