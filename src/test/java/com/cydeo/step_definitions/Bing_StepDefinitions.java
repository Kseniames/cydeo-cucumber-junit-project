package com.cydeo.step_definitions;

import com.cydeo.pages.BingSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class Bing_StepDefinitions {
 BingSearchPage bingSearchPage = new BingSearchPage();
    @Given("user is on the Bing search page")
    public void user_is_on_the_bing_search_page() {
        Driver.getDriver().get("https://www.bing.com/");
    }

    @When("user enter orange in the Bing search box")
    public void user_enter_orange_in_the_bing_search_box() {
  bingSearchPage.bingSearchBox.sendKeys("orange" + Keys.ENTER);
    }

    @Then("user should see orange in the title in the title")
    public void userShouldSeeOrangeInTheTitleInTheTitle() {

        BrowserUtils.verifyTitle("orange - Search");
    }


    @When("user enters {string} in the Bing search box")
    public void userEntersInTheBingSearchBox(String searchKey) {

        bingSearchPage.bingSearchBox.sendKeys(searchKey + Keys.ENTER);

    }

    @Then("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String expectedTitle) {

        BrowserUtils.verifyTitle(expectedTitle);
        //BrowserUtils.verifyTitleContains(expectedTitle);

    }
}