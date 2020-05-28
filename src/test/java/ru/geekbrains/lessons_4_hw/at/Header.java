package ru.geekbrains.lessons_4_hw.at;

import org.openqa.selenium.By;

public class Header {

    By entireHeaderLocator = By.id("top-menu");
    By searchButtonLocator = By.xpath("//li/a[@class='show-search-form']");
    By searchIconLocator = By.cssSelector("li[class='gb-top-menu__item'] svg[class='svg-icon icon-search ']");
    By loginButtonLocator = By.cssSelector("a[href='/login']");
    By registrationButtonLocator = By.cssSelector("a[href='/register']");
}
