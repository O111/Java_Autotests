package ru.geekbrains.seleniumTesting.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user_email")
    private WebElement textfieldLogin;
    @FindBy(id = "user_password")
    private WebElement textfieldPassword;
    @FindBy(css = "input[data-testid='login-submit']")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Input {email} in login textfield")
    public LoginPage inputLogin(CharSequence email) {
        textfieldLogin.sendKeys(email);
        return this;
    }

    @Step("Input {pass} in password textfield")
    public LoginPage inputPassword(CharSequence pass) {
        textfieldPassword.sendKeys(pass);
        return this;
    }

    @Step("Click button Submit")
    public LoginPage submit() {
        buttonSubmit.click();
        return this;
    }
}
