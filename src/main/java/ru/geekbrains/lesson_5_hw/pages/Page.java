package ru.geekbrains.lesson_5_hw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Page extends BasePage {

    @FindBy(className = "gb-header__title")
    private WebElement pageHeader;

    @FindBy(css = "ul > li > .show-search-form")
    private WebElement searchButton;
    @FindBy(css = ".search-panel__search-field")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@class='c9e3 _311d']")
    private WebElement popup;

    private NavigationTab navigationTab;

    public Page(WebDriver driver) {
        super(driver);
        navigationTab = new NavigationTab(driver);
    }

    public NavigationTab getNavigationTab() {
        return navigationTab;
    }

    public Page checkHeader(String expected) {
        assertEquals(expected, pageHeader.getText());
        return this;
    }

    public SearchPage searchInput(CharSequence search) {
        searchButton.click();
        searchInput.sendKeys(search);
        return new SearchPage(driver);
    }

    public Page popupClose() {
        if (popup != null) {popup.click();}
        return this;
    }
}
