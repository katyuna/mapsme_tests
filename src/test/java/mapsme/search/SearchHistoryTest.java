package mapsme.search;

import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class SearchHistoryTest extends BaseTest {
    @Test
    @Order(1)
    @Issue("1016")
    @DisplayName("Search history displayed after repeated search")
    @Description("Search history displayed after repeated search." +
            "Desired object displays in search history.")
    public void testSearchHistory() {
        Steps.waitSearchButton();
        Steps.clickSearchButton();
        Steps.clickSearchField();
        Steps.setSearchString();
        String expected = Steps.getSearchFieldText();
        Steps.waitSearchResults();
        Steps.clickSearchResult();
        Steps.closePlacePageFromSearchResults();
        Steps.clickSearchCancel();
        Steps.closeSearchBottomSheetByX();
        Steps.clickSearchButton();
        Steps.clickSearchField();
        Steps.waitSearchHistory();

        String actual = searchBottomSheet.searchHistoryGetText();

        System.out.println("1" + expected);
        System.out.println("2" + actual);

    }
}
