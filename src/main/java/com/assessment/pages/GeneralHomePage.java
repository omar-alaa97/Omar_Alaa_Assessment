package com.assessment.pages;

import com.assessment.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GeneralHomePage extends Base {
    private WebDriver driver;
    private By tweetTextBox = By.id("placeholder-fd2ba");
    private By characterExceedingAlert = By.xpath("//div[contains(text(),'You have exceeded the character limit by')]");
    private By highlightedText = By.xpath("//span[@style='background-color: rgb(253, 155, 201);']");
    private By unclickableTweetButton = By.xpath("//div[@aria-disabled='true']");
    private By addPhotos = By.xpath("//path[@aria-label='Add photos or video']");
    private By pollButton = By.cssSelector("svg[class='r-1cvl2hr r-4qtqp9 r-yyyyoo r-z80fyv r-dnmrzs r-bnwqim r-1plcrui r-lrvibr r-19wmn03']");
    private By pollQuestion = By.className("public-DraftStyleDefault-block public-DraftStyleDefault-ltr");
    private By pollChoices = By.className("css-1dbjc4n r-18u37iz r-1pi2tsx r-1wtj0ep r-u8s1d r-13qz1uu");
    private By tweetButton = By.xpath("//div[@data-testid='tweetButtonInline']");
    private By accountIcon = By.className("css-1dbjc4n r-i49rur r-1twgtwe r-sdzlij r-rs99b7 r-1p0dtai r-1mi75qu r-1d2f490 r-1ny4l3l r-u8s1d r-zchlnj r-ipm5af r-o7ynqc r-6416eg");
    private By photosLimitError = By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div[1]/span");
    public String question;

    public GeneralHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterExceedingTweet() {
        for (int i = 0; i <= 285; i++) {
            driver.findElement(tweetTextBox).sendKeys("a");
        }
    }

    public void addPhotos() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(pollButton));
        driver.findElement(addPhotos).sendKeys(" src/main/resources/images(1).png \n " +
                "src/main/resources/images(2).png \n" +
                " src/main/resources/images(3).jpg \n src/main/resources/images(4).png \n " +
                "src/main/resources/images(5).jpg ");
    }

    public void createPoll(String question, String firstOption, String secondOption) {
        driver.findElement(pollButton).click();
        driver.findElement(pollQuestion).sendKeys(question);
        List<WebElement> choices = driver.findElements(pollChoices);
        choices.get(0).sendKeys(firstOption);
        choices.get(1).sendKeys(secondOption);
        driver.findElement(tweetButton).click();
    }

    public PersonalHomePage goToAccountHomePage() {
        driver.findElement(accountIcon).click();
        return new PersonalHomePage(driver);
    }

    public boolean checkCharacterExceedingAlert() {
        return driver.findElement(characterExceedingAlert).isDisplayed();
    }

    public boolean checkHighlightedText() {
        return driver.findElement(highlightedText).isDisplayed();
    }

    public boolean checkUnclickableTweetButton() {
        return driver.findElement(unclickableTweetButton).isDisplayed();
    }

    public boolean checkPhotolimitError() {
        return driver.findElement(photosLimitError).isDisplayed();
    }


}
