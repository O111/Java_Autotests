package ru.geekbrains.lesson_7_hw.at;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson_7_hw.at.base.BaseTest;
import ru.geekbrains.lesson_7_hw.pages.LoginPage;

public class LoginTest extends BaseTest {

    private static final String LOGIN = "hao17583@bcaoo.com";
    private static final String PASSWORD = "hao17583";

    @BeforeEach
    @Step("Open '/login' page")
    public void openSiteLogin() {
        driver.get(BASE_URL + "/login");
    }

    @Test
    @DisplayName("login test")
    public void loginTest() {
        new LoginPage(driver)
                .inputLogin(LOGIN)
                .inputPassword(PASSWORD)
                .submit()
                .checkHeader("Главная")
                .getNavigationTab().clickButton("Курсы")
                .getCoursesPage().clickTab("Курсы")
                .clickCheckbox("Бесплатные")
                .clickCheckbox("Тестирование")
                .checkCoursePresence("Тестирование ПО. Уровень 1")
                .checkCoursePresence("Тестирование ПО. Уровень 2");
    }
}
