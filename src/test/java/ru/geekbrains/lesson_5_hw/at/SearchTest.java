package ru.geekbrains.lesson_5_hw.at;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ru.geekbrains.lesson_5_hw.at.base.BaseTest;
import ru.geekbrains.lesson_5_hw.pages.SearchPage;

public class SearchTest extends BaseTest {

    @BeforeEach
    public void openSiteCourses() {
        driver.get(BASE_URL + "/courses");
    }

    @Test
    @DisplayName("check search java")
    public void searchJavaTest() {
        new SearchPage(driver)
                .searchInput("java")
                .checkSearchResultDisplayed()
                .checkSearchResult();
    }
}
