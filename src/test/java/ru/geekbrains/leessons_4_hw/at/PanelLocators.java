package ru.geekbrains.leessons_4_hw.at;

import org.openqa.selenium.By;

public class PanelLocators {
    By professionsTabLocator = By.cssSelector("ul.search-page-tabs > li > a[data-tab='professions']");
    By coursesTabLocator = By.cssSelector("ul.search-page-tabs > li > a[data-tab='courses']");
    By webinarsTabLocator = By.cssSelector("ul.search-page-tabs > li > a[data-tab='webinars']");
    By blogsTabLocator = By.cssSelector("ul.search-page-tabs > li > a[data-tab='blogs']");
    By forumsTabLocator = By.cssSelector("ul.search-page-tabs > li > a[data-tab='forums']");
    By testsTabLocator = By.cssSelector("ul.search-page-tabs > li > a[data-tab='tests']");
    By companiesTabLocator = By.cssSelector("ul.search-page-tabs > li > a[data-tab='companies']");

    By professionsLocator = By.cssSelector("ul.search-page-tabs a[data-tab='professions'] > span");
    By coursesLocator = By.cssSelector("ul.search-page-tabs a[data-tab='courses'] > span");
    By webinarsLocator = By.cssSelector("ul.search-page-tabs a[data-tab='webinars'] > span");
    By blogsLocator = By.cssSelector("ul.search-page-tabs a[data-tab='blogs'] > span");
    By forumsLocator = By.cssSelector("ul.search-page-tabs a[data-tab='forums'] > span");
    By testsLocator = By.cssSelector("ul.search-page-tabs a[data-tab='tests'] > span");
}
