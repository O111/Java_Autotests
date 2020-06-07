package ru.geekbrains.lesson_7_hw.at;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ru.geekbrains.lesson_7_hw.at.base.BaseTest;
import ru.geekbrains.lesson_7_hw.pages.SearchPage;

public class SearchTest extends BaseTest {

    @BeforeEach
    @Step("Open '/courses' page")
    public void openSiteCourses() {
        driver.get(BASE_URL + "/courses");
    }

    @Test
    @DisplayName("check search java")
    public void searchJavaTest() {
        new SearchPage(driver)
                .popupClose()
                .getSearchPage().searchInput("java")
                .checkSearchResultDisplayed()
                .checkSearchResult();
    }
}
