package ru.geekbrains.homework_3.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareerTest extends BaseTest {

    @Test
    void navPanelTest() {
        driver.get(BASE_URL + "/login");   // Исходная позиция
        WebElement careerButton = driver.findElement(By.cssSelector("nav > a[href='/career']"));
        careerButton.click();

        String header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Карьера", header);
    }

    @Test
    void headerTest() {                                                     // Пример выполнения пункта б)
        driver.get(BASE_URL + "/career");
        WebElement entireHeader = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("top-menu")));
        Assertions.assertTrue(entireHeader.isDisplayed());

        WebElement searchButton = driver.findElement(By.xpath("//li/a[@class='show-search-form']"));
        Assertions.assertTrue(searchButton.isDisplayed());

        WebElement searchIcon = driver.findElement(By
                .cssSelector("li[class='gb-top-menu__item'] svg[class='svg-icon icon-search ']"));
        Assertions.assertTrue(searchIcon.isDisplayed());

        WebElement loginButton = driver.findElement(By.cssSelector("a[href='/login']"));
        Assertions.assertTrue(loginButton.isDisplayed());

        WebElement registrationButton = driver.findElement(By.cssSelector("a[href='/register']"));
        Assertions.assertTrue(registrationButton.isDisplayed());
    }

    @Test
    void footerTest() {
        driver.get(BASE_URL + "/career");
        WebElement entireFooter = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("site-footer")));
        Assertions.assertTrue(entireFooter.isDisplayed());

        WebElement vkLink = driver.findElement(By.cssSelector("a[href='//vk.com/geekbrainsru']"));
        Assertions.assertTrue(vkLink.isDisplayed());

        WebElement feedbackLink = driver.findElement(By.cssSelector("a[href='/feedbacks']"));
        Assertions.assertTrue(feedbackLink.isDisplayed());
        Assertions.assertEquals("Отзывы", feedbackLink.getText());

        WebElement telLink = driver.findElement(By.cssSelector("a[class='site-footer__phone']"));
        Assertions.assertTrue(telLink.isDisplayed());
        Assertions.assertEquals("8 800 700-68-41", telLink.getText());
    }
}
