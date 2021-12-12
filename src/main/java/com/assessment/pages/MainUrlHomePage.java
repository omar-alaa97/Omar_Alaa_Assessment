package com.assessment.pages;

import com.assessment.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainUrlHomePage extends Base {

    private WebDriver driver;
    private By loginLink = By.xpath("//span[text()='Sign in']");

    public MainUrlHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginOptionsPage clickLink() {
        driver.findElement(loginLink).click();
        return new LoginOptionsPage(driver);
    }

}
