package mapsme.search;

import io.qameta.allure.Issue;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class SearchBottomSheetTest extends BaseTest {
    @Test
    @Order(1)
    @Issue("1010")
    @DisplayName("Open and assert Search bottom sheet")
    @Description(
            "The search bottom sheet has been opened and closed by tap on [x]." +
            " Search bottom sheet contains search field, close button and at least one category buttons")

    public void testOpenAndCloseSearchBottomSheet() {
        Steps.waitSearchButton();
        Steps.clickSearchButton();
        Steps.assertSearchIcon();
        Steps.assertCloseButton();
        Steps.assertCategoryIcon();
        Steps.closeSearchBottomSheetByX();
    }
}
