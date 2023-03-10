package com.cydeo.step_definitions;

import com.cydeo.pages.WikiSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wiki_StepDefinitions {

    WikiSearchPage wikiSearchPage = new WikiSearchPage();
    @Given("user is on the Wiki home page")
    public void user_is_on_the_wiki_home_page() {

        Driver.getDriver().get("https://www.wikipedia.org/");
    }
    @When("user type Steve Jobs in the wiki search box")
    public void user_type_steve_jobs_in_the_wiki_search_box() {
   wikiSearchPage.wikiSearchBox.sendKeys("Steve Jobs");

    }
    @Then("user click wiki search button")
    public void user_click_wiki_search_button() {
       wikiSearchPage.wikiSearchButton.click();
    }
    @Then("user should see Steve Jobs in the title")
    public void user_should_see_steve_jobs_in_the_title() {
        BrowserUtils.verifyTitle("Steve Jobs - Wikipedia");
    }

    @Then("User sees Steve Jobs is in the main header")
    public void userSeesSteveJobsIsInTheMainHeader() {
        //wikiSearchPage.wikiSearchHeader.getText();
        String expectResult="Steve Jobs";
        String actualResult=wikiSearchPage.wikiSearchHeader.getText();
        Assert.assertEquals("pass",expectResult,actualResult);

    }

    @Then("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String expect) {
        String actualImageHeader= wikiSearchPage.wikiImageHeader.getText();
        Assert.assertEquals(expect,actualImageHeader);
    }

    @And("User clicks wiki search button")
    public void userClicksWikiSearchButton() {
    }

    @When("User types {string} in the wiki search box")
    public void userTypesInTheWikiSearchBox(String arg0) {
    }
}
