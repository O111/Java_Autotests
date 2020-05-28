package ru.geekbrains.lessons_4_hw.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CareerTest extends BaseTest {

    @Test
    public void navPanelTest() {
        driver.get(BASE_URL + "/login");   // Исходная позиция
        WebElement careerButton = driver.findElement(By.cssSelector("nav > a[href='/career']"));
        careerButton.click();

        String header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Карьера", header);
    }

    @ParameterizedTest
    @MethodSource("streamHeaderLocators")  // проверка хедера
    public void headerTest(By locator) {
        driver.get(BASE_URL + "/career");
        super.locationTest(locator);
    }

    @ParameterizedTest
    @MethodSource("streamFooterLocators")   // проверка футера
    public void footerTest(By locator) {
        driver.get(BASE_URL + "/career");
        super.locationTest(locator);
    }
}
