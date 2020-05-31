package ru.geekbrains.lesson_5_hw.at;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.lesson_5_hw.at.base.BaseTest;
import ru.geekbrains.lesson_5_hw.pages.NavigationTab;

import java.util.stream.Stream;

@Execution(value = ExecutionMode.CONCURRENT)
public class NavigationTest extends BaseTest {

    public static Stream<String> pageGenerator() {
        return Stream.of("Карьера", "Тесты", "Блог", "Форум", "Вебинары", "Курсы");
    }

    @BeforeEach
    public void openSite() {
        driver.get(BASE_URL + "/career");
    }

    @ParameterizedTest
    @DisplayName("check navigation items")
    @MethodSource("pageGenerator")
    public void navigationPanelTest(String buttonTitle) {
        new NavigationTab(driver)
                .clickButton(buttonTitle)
                .checkHeader(buttonTitle);
    }
}
