/*
* а) Вынести проверку каждой страницы в отдельный тест
* б) Реализовать проверку отображения блоков Header и Footer на каждой странице сайта (как минимум самого блока)
*     (см. CareerTest)
* в*) Создать классы Header и Footer, в которых создать локаторы ко всем элементам в этих блоках
*/

package ru.geekbrains.homework_3.at;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public abstract class BaseTest {

    protected WebDriver driver;
    protected final String BASE_URL = "https://geekbrains.ru";

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));

        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
