package ru.geekbrains.lesson_5_hw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user_email")
    private WebElement login;
    @FindBy(id = "user_password")
    private WebElement password;
    @FindBy(css = "input[data-testid='login-submit']")
    private WebElement buttonSubmit;

    public LoginPage inputLogin(CharSequence email) {
        login.sendKeys(email);
        return this;
    }

    public LoginPage inputPassword(CharSequence pass) {
        password.sendKeys(pass);
        return this;
    }

    public LoginPage submit() {
        buttonSubmit.click();;
        return this;
    }
}
