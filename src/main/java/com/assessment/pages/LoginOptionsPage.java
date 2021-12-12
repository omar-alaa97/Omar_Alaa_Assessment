package com.assessment.pages;

import com.assessment.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginOptionsPage extends Base {

    private WebDriver driver;
    private By emailLoginOption = By.linkText("Use phone, email or username");

    public LoginOptionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage goToLoginPage() {
        driver.findElement(emailLoginOption).click();
        return new LoginPage(driver);
    }
}
