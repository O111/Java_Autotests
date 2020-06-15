package ru.geekbrains.seleniumTesting.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchPage extends BasePage {

    @FindBy(css = "ul > li > .show-search-form")
    private WebElement searchButton;
    @FindBy(css = ".search-panel__search-field")
    private WebElement searchInput;

    @FindBy(css = "ul.search-page-tabs > li > a[data-tab='professions']")
    private WebElement professionsTab;
    @FindBy(css = "ul.search-page-tabs > li > a[data-tab='courses']")
    private WebElement coursesTab;
    @FindBy(css = "ul.search-page-tabs > li > a[data-tab='webinars']")
    private WebElement webinarsTab;
    @FindBy(css = "ul.search-page-tabs > li > a[data-tab='blogs']")
    private WebElement blogsTab;
    @FindBy(css = "ul.search-page-tabs > li > a[data-tab='forums']")
    private WebElement forumsTab;
    @FindBy(css = "ul.search-page-tabs > li > a[data-tab='tests']")
    private WebElement testsTab;
    @FindBy(css = "ul.search-page-tabs > li > a[data-tab='companies']")
    private WebElement companiesTab;

    @FindBy(css ="ul.search-page-tabs a[data-tab='professions'] > span" )
    private WebElement professions;
    @FindBy(css ="ul.search-page-tabs a[data-tab='courses'] > span" )
    private WebElement courses;
    @FindBy(css ="ul.search-page-tabs a[data-tab='webinars'] > span" )
    private WebElement webinars;
    @FindBy(css ="ul.search-page-tabs a[data-tab='blogs'] > span" )
    private WebElement blogs;
    @FindBy(css ="ul.search-page-tabs a[data-tab='forums'] > span" )
    private WebElement forums;
    @FindBy(css ="ul.search-page-tabs a[data-tab='tests'] > span" )
    private WebElement tests;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click button 'Поиск' and input '{search}' in search field")
    public SearchPage searchInput(CharSequence search) {
        searchButton.click();
        searchInput.sendKeys(search);
        return this;
    }

    @Step("Check search result is displayed")
    public SearchPage checkSearchResultDisplayed() {

        assertThat(professionsTab.isDisplayed(), is(true));
        assertThat(coursesTab.isDisplayed(), is(true));
        assertThat(webinarsTab.isDisplayed(), is(true));
        assertThat(blogsTab.isDisplayed(), is(true));
        assertThat(forumsTab.isDisplayed(), is(true));
        assertThat(testsTab.isDisplayed(), is(true));
        assertThat(companiesTab.isDisplayed(), is(true));

        return this;
    }

    @Step("Check search result")
    public SearchPage checkSearchResult() {

        assertThat(Integer.parseInt(professions.getText()), greaterThan(1));
        assertThat(Integer.parseInt(courses.getText()), greaterThan(15));
        assertThat(Integer.parseInt(webinars.getText()), allOf(
                        greaterThan(180),
                        lessThan(300)));
        assertThat(Integer.parseInt(blogs.getText()), greaterThan(300));
        assertThat(Integer.parseInt(forums.getText()), not(equalTo(350)));
        assertThat(Integer.parseInt(tests.getText()), not(equalTo(0)));

        return this;
    }
}
