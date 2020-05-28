package ru.geekbrains.lessons_4_hw.at;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.stream.Stream;

public abstract class BaseTest {

    protected WebDriver driver;
    protected final String BASE_URL = "https://geekbrains.ru";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));

        driver = new ChromeDriver(options);
    }

    public void locationTest(By locator) {                                        // Шаблон теста
        WebElement webElement = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        Assertions.assertTrue(webElement.isDisplayed());
    }

    public static Stream<By> streamHeaderLocators() {
        Header header = new Header();

        return Stream.of(
                header.entireHeaderLocator,
                header.searchButtonLocator,
                header.searchIconLocator,
                header.loginButtonLocator,
                header.registrationButtonLocator
        );
    }

    public static Stream<By> streamFooterLocators() {
        Footer footer = new Footer();

        return Stream.of(
                footer.entireFooterLocator,
                footer.vkLinkLocator,
                footer.feedbackLinkLocator,
                footer.telLinkLocator
        );
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public void popupClose() {
        WebElement popup = driver.findElement(By.xpath("//button[@class='c9e3 _311d']")); // закрытие баннера
        if (popup != null) {popup.click();}         // и без него всё работает, поэтому не использовал, а с ним, наверно,
    }                                               // исключение надо обрабатывать или ожидание прописывать
}
