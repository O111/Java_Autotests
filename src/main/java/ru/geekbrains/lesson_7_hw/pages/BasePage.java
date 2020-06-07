package ru.geekbrains.lesson_7_hw.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasePage {
    protected WebDriver driver;

    @FindBy(className = "gb-header__title")
    private WebElement pageHeader;

    @FindBy(xpath = "//button[@class='c9e3 _311d']")
    private WebElement popup;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Check {expected} is in header on page")
    public Page checkHeader(String expected) {
        assertEquals(expected, pageHeader.getText());
        return new Page(driver);
    }

    @Step("Close popup")
    public Page popupClose() {
        if (popup != null) {
            popup.click();
        }
        return new Page(driver);
    }
}
