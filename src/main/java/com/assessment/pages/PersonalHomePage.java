package com.assessment.pages;

import com.assessment.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalHomePage extends Base {

    private WebDriver driver;


    public PersonalHomePage(WebDriver driver) {
        this.driver = driver;

    }

    public boolean findPoll(String question) {
        return driver.findElement(By.xpath("//span[text()='" + question + "']")).isDisplayed();
    }
}
