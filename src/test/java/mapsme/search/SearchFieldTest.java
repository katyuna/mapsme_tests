package mapsme.search;

import io.qameta.allure.Attachment;
import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.openqa.selenium.logging.LogType.DRIVER;

public class SearchFieldTest extends BaseTest {
    @Test
    @Order(1)
    @Issue("1014, 1034, 1035")
    @DisplayName("Search via search field in Search bottom sheet")
    @Description("The object has been found via search field in Search bottom sheet." +
            "Search result is clickable." +
            "Search results can be clear. " +
            "Search results can be cancel.")
    public void testSearchViaSearchField() {
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

