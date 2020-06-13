package ru.geekbrains.lesson_8_hw.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class Page extends BasePage {

    private NavigationTab navigationTab;
    private SearchPage searchPage;
    private LoginPage loginPage;
    private CoursesPage coursesPage;

    public Page(WebDriver driver) {
        super(driver);
        navigationTab = new NavigationTab(driver);
        searchPage = new SearchPage(driver);
        loginPage = new LoginPage(driver);
        coursesPage = new CoursesPage(driver);
    }

    @Step("In navigation tab")
    public NavigationTab getNavigationTab() {
        return navigationTab;
    }

    @Step("On Search page")
    public SearchPage getSearchPage() {
        return searchPage;
    }

    @Step("On Login page")
    public LoginPage getLoginPage() {
        return loginPage;
    }

    @Step("On Courses page")
    public CoursesPage getCoursesPage() {
        return coursesPage;
    }
}
