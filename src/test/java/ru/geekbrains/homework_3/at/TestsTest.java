package ru.geekbrains.homework_3.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestsTest extends BaseTest {

    @Test
    void navPanelTest() {
        driver.get(BASE_URL + "/login");
        WebElement testsButton = driver.findElement(By.cssSelector("nav > a[href='/tests']"));
        testsButton.click();

        String header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Тесты", header);
    }

    @Test
    void headerTest() {
        driver.get(BASE_URL + "/tests");
        Header header = new Header();

        WebElement entireHeader = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(header.entireHeaderLocator));
        Assertions.assertTrue(entireHeader.isDisplayed());

        WebElement searchButton = driver.findElement(header.searchButtonLocator);
        Assertions.assertTrue(searchButton.isDisplayed());

        WebElement searchIcon = driver.findElement(header.searchIconLocator);
        Assertions.assertTrue(searchIcon.isDisplayed());

        WebElement loginButton = driver.findElement(header.loginButtonLocator);
        Assertions.assertTrue(loginButton.isDisplayed());

        WebElement registrationButton = driver.findElement(header.registrationButtonLocator);
        Assertions.assertTrue(registrationButton.isDisplayed());
    }

    @Test
    void footerTest() {
        driver.get(BASE_URL + "/tests");
        Footer footer = new Footer();

        WebElement entireFooter = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(footer.entireFooterLocator));
        Assertions.assertTrue(entireFooter.isDisplayed());

        WebElement vkLink = driver.findElement(footer.vkLinkLocator);
        Assertions.assertTrue(vkLink.isDisplayed());

        WebElement feedbackLink = driver.findElement(footer.feedbackLinkLocator);
        Assertions.assertTrue(feedbackLink.isDisplayed());
        Assertions.assertEquals("Отзывы", feedbackLink.getText());

        WebElement telLink = driver.findElement(footer.telLinkLocator);
        Assertions.assertTrue(telLink.isDisplayed());
        Assertions.assertEquals("8 800 700-68-41", telLink.getText());
    }
}
