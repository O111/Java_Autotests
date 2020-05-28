package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Disabled
public class SearchTest extends BaseTest {

    @Test
    void searchJavaTest() {
        // Открываем страницу с курсами
        driver.get(BASE_URL + "/courses");
        // Закрываем баннер
        driver.findElement(By.xpath("//div/div/button[*]")).click();

        WebElement searchButton = driver.findElement(By.cssSelector("ul > li > .show-search-form"));
        searchButton.click();

        WebElement searchInput = driver.findElement(By.cssSelector(".search-panel__search-field"));
        searchInput.sendKeys("java");
        // В после отправки поискового запроса, нужно дождаться прогрузки страницы.
        // Попробуем использовать явные ожидания. Будем ждать до тех пор, пока панель, на которой расположены
        //  нужные нам элементы не будет прогружена.

        // Создаем экземпляр класса WebDriverWait, в конструктор передаем текущий экземпляр драйвера
        // и количество секунд, которое нужно ждать.
        WebDriverWait wait = new WebDriverWait(driver, 15);
        // передаем в него условие - ждать до тех пор, пока элемент с указанным CSS селектором не появится на экране
        // если ожидание затянется более чем на 15 секунд - тест упадет.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.search-page-tabs")));

        // Мы нашли первую интересующую нас плашку.
        WebElement professionsTab = driver
                .findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='professions']"));
        // Давайте проверим, что она видна пользователю.
        Assertions.assertTrue(professionsTab.isDisplayed());

        // С остальными элементами поступим по аналогии
        WebElement coursesTab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='courses']"));
        WebElement webinarsTab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='webinars']"));
        WebElement blogsTab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='blogs']"));
        WebElement forumsTab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='forums']"));
        WebElement testsTab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='tests']"));
        WebElement companiesTab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='companies']"));

        Assertions.assertTrue(coursesTab.isDisplayed());
        Assertions.assertTrue(webinarsTab.isDisplayed());
        Assertions.assertTrue(blogsTab.isDisplayed());
        Assertions.assertTrue(forumsTab.isDisplayed());
        Assertions.assertTrue(testsTab.isDisplayed());
        Assertions.assertTrue(companiesTab.isDisplayed());
    }
}
