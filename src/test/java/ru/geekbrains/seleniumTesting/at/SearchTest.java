package ru.geekbrains.seleniumTesting.at;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ru.geekbrains.seleniumTesting.at.base.BaseTest;
import ru.geekbrains.seleniumTesting.pages.SearchPage;

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
