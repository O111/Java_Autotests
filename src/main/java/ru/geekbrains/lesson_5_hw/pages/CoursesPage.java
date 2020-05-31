package ru.geekbrains.lesson_5_hw.pages;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CoursesPage extends BasePage{

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "prof-link")
    private WebElement professions;
    @FindBy(id = "free-link")
    private WebElement free;
    @FindBy(id = "cour-link")
    private WebElement courses;
    @FindBy(css = ".nav-tabs-item a[target]")
    private WebElement companies;

    @FindBy(id = "filter-0")
    private WebElement checkboxFree;   // Остальные по аналогии
    @FindBy(id = "filter-9")
    private WebElement checkboxTesting;

    @FindBy(css = "div[data-id='84'] span")  // Остальные можно описать по аналогии
    private WebElement course1;
    @FindBy(css = "div[data-id='85'] span")
    private WebElement course2;

    public CoursesPage clickTab(String titleTab) {
        switch (titleTab) {
            case "Профессии": {
                professions.click();
                break;
            }
            case "Бесплатные интенсивы": {
                free.click();
                break;
            }
            case "Курсы": {
                courses.click();
                break;
            }
            case "Компаниям": {
                companies.click();
                break;
            }
            default: {
                throw new NotFoundException("Element not found " + titleTab);
            }
        }
        return this;
    }

    public CoursesPage clickCheckbox(String titleCheckbox) {
        switch (titleCheckbox) {
            case "Бесплатные": {
                checkboxFree.click();
                break;
            }
            case "Тестирование": {
                checkboxTesting.click();
                break;
            }
            default: {
                throw new NotFoundException("Element not found " + titleCheckbox + " in checkbox");
            }
        }
        return this;
    }

    public CoursesPage checkCoursePresence(String title) {
        switch (title) {
            case "Тестирование ПО. Уровень 1": {
                assertThat(course1.getText(), equalTo(title));
                break;
            }
            case "Тестирование ПО. Уровень 2": {
                assertThat(course2.getText(), equalTo(title));
                break;
            }
            default: {
                throw new NotFoundException("Course not found " + title);
            }
        }
        return this;
    }
}
