package com.assessment.pages;

import com.assessment.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base {
    private WebDriver driver;
    private By emailField = By.name("session[username_or_email]");
    private By passwordField = By.name("session[password]");
    private By loginButton = By.xpath("//span[text()='Log in']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public GeneralHomePage login() {
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        driver.findElement(emailField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(loginButton).click();
        return new GeneralHomePage(driver);
    }


}
