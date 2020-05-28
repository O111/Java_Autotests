package ru.geekbrains.lessons_4_hw.at;

import org.openqa.selenium.By;

public class Footer {

    By entireFooterLocator = By.className("site-footer");
    By vkLinkLocator = By.cssSelector("a[href='//vk.com/geekbrainsru']"); // остальные по аналогии
    By feedbackLinkLocator = By.cssSelector("a[href='/feedbacks']");      // остальные по аналогии
    By telLinkLocator = By.cssSelector("a[class='site-footer__phone']");
}
