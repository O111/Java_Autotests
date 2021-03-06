package ru.geekbrains.seleniumTesting.at.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected final String BASE_URL = "https://geekbrains.ru";
    protected WebDriver driver;

    @BeforeEach
    @Step("Open Chrome browser")
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterEach
    @Step("Quit browser")
    public void tearDown() {
        driver.quit();
    }
}
