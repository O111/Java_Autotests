package ru.geekbrains.lessons_4_hw.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CoursesTest extends BaseTest {

    @Test
    void navPanelTest() {
        driver.get(BASE_URL + "/login");
        WebElement coursesButton = driver.findElement(By.cssSelector("nav > a[href='/courses']"));
        coursesButton.click();

        String header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Курсы", header);
    }

    @ParameterizedTest
    @MethodSource("streamHeaderLocators")
    public void headerTest(By locator) {
        driver.get(BASE_URL + "/courses");
        super.locationTest(locator);
    }

    @ParameterizedTest
    @MethodSource("streamFooterLocators")
    public void footerTest(By locator) {
        driver.get(BASE_URL + "/courses");
        super.locationTest(locator);
    }
}
