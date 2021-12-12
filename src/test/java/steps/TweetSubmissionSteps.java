package steps;

import com.assessment.base.Base;
import com.assessment.pages.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TweetSubmissionSteps extends Base {

    String question;
    MainUrlHomePage mainUrlHomePage;

    GeneralHomePage generalHomePage;
    PersonalHomePage personalHomePage;


    @Given("User open the website and go to login page and enter valid credentials email & password")
    public void login_To_Homepage() {
        initialization();
        driver.get(props.getProperty("url"));

        mainUrlHomePage = new MainUrlHomePage(driver);
        LoginOptionsPage loginOptionsPage = mainUrlHomePage.clickLink();
        LoginPage loginPage = loginOptionsPage.goToLoginPage();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("session[username_or_email]")));

        generalHomePage = loginPage.login();

    }

    @When("User enter more than 280 characters inside tweet box")
    public void surpass_characters_limits() {
        generalHomePage.enterExceedingTweet();
    }

    @Then("tweet button should unclickable and red warning appear below tweet box and characters are highlighted in red")
    public void check_behaviour_upon_exceeding_character_limit() {
        Assert.assertTrue(generalHomePage.checkCharacterExceedingAlert());
        Assert.assertTrue(generalHomePage.checkHighlightedText());
        Assert.assertTrue(generalHomePage.checkUnclickableTweetButton());

    }

    @When("User add more than 4 images to one tweet")
    public void user_add_more_than_images_to_one_tweet() {
        generalHomePage.addPhotos();
    }

    @Then("An error message should appear saying 'please add 1 GIF or up to 4 photos'")
    public void an_error_message_should_appear_saying() {
        Assert.assertTrue(generalHomePage.checkPhotolimitError());

    }

    @When("User Create Poll")
    public void user_create_poll(DataTable whenData) {
        generalHomePage.createPoll(whenData.cell(0, 0), whenData.cell(0, 1), whenData.cell(0, 2));
        personalHomePage = generalHomePage.goToAccountHomePage();
        question = whenData.cell(0, 0);
    }

    @Then("poll appear on his personal page")
    public void poll_appear_on_his_personal_page() {
        Assert.assertTrue(personalHomePage.findPoll(question));
    }

}
