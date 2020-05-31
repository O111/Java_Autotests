package ru.geekbrains.lesson_5_hw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    public NavigationTab getNavigationTab() {
        return navigationTab;
    }

    public SearchPage getSearchPage() {
        return searchPage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public CoursesPage getCoursesPage() {
        return coursesPage;
    }
}
