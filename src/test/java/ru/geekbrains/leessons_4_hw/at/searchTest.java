package ru.geekbrains.leessons_4_hw.at;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class searchTest extends BaseTest {

    @Test
    public void searchJavaTest() {
        driver.get(BASE_URL + "/courses");

        WebElement popup = driver.findElement(By.xpath("//button[@class='c9e3 _311d']")); // закрытие баннера
        if (popup != null) {popup.click();}

        WebElement searchButton = driver.findElement(By.cssSelector("ul > li > .show-search-form"));
        searchButton.click();

        WebElement searchInput = driver.findElement(By.cssSelector(".search-panel__search-field"));
        searchInput.sendKeys("java");

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.search-page-tabs")));

        PanelLocators panelLocator = new PanelLocators();

        WebElement professionsTab = driver.findElement(panelLocator.professionsTabLocator);
        WebElement coursesTab = driver.findElement(panelLocator.coursesTabLocator);
        WebElement webinarsTab = driver.findElement(panelLocator.webinarsTabLocator);
        WebElement blogsTab = driver.findElement(panelLocator.blogsTabLocator);
        WebElement forumsTab = driver.findElement(panelLocator.forumsTabLocator);
        WebElement testsTab = driver.findElement(panelLocator.testsTabLocator);
        WebElement companiesTab = driver.findElement(panelLocator.companiesTabLocator);

        assertThat(professionsTab.isDisplayed(), is(true));
        assertThat(coursesTab.isDisplayed(), is(true));
        assertThat(webinarsTab.isDisplayed(), is(true));
        assertThat(blogsTab.isDisplayed(), is(true));
        assertThat(forumsTab.isDisplayed(), is(true));
        assertThat(testsTab.isDisplayed(), is(true));
        assertThat(companiesTab.isDisplayed(), is(true));

        WebElement professions = driver.findElement(panelLocator.professionsLocator);
        assertThat(Integer.parseInt(professions.getText()), greaterThan(1)); //так короче

        WebElement courses = driver.findElement(panelLocator.coursesLocator);
        assertThat(Integer.parseInt(courses.getText()), greaterThan(15));

        WebElement webinars = driver.findElement(panelLocator.webinarsLocator);
        assertThat(Integer.parseInt(webinars.getText()), allOf(
                greaterThan(180),
                lessThan(300)
        ));

        WebElement blogs = driver.findElement(panelLocator.blogsLocator);
        assertThat(Integer.parseInt(blogs.getText()), greaterThan(300));

        WebElement forums = driver.findElement(panelLocator.forumsLocator);
        assertThat(Integer.parseInt(forums.getText()), not(
                equalTo(350)
        ));

        WebElement tests = driver.findElement(panelLocator.testsLocator);
        assertThat(Integer.parseInt(tests.getText()),not(
                equalTo(0)
        ));
    }
}
