package com.cydeo.step_definitions;

import com.cydeo.pages.EtsySearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Etsy_StepDefinitions {

    @Given("user is on the Etsy homepage")
    public void user_is_on_the_etsy_homepage() {
        Driver.getDriver().get("https://www.etsy.com/");

    }
    @Then("user should see title is as expected")
    public void user_should_see_title_is_as_expected() {
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        BrowserUtils.verifyTitle(expectedTitle);
    }

    EtsySearchPage etsySearchPage = new EtsySearchPage();
    @When("User types Wooden Spoon in the search box")
    public void user_types_wooden_spoon_in_the_search_box() {
      etsySearchPage.searchBox.sendKeys("Wooden Spoon");
    }
    @When("user click to Etsy search button")
    public void user_click_to_etsy_search_button() {
     etsySearchPage.searchButton.click();
    }
    @Then("user sees Wooden Spoon is in the title")
    public void user_sees_wooden_spoon_is_in_the_title() {
     BrowserUtils.verifyTitle("Wooden spoon - Etsy");
    }


    @When("User types {string} in the search box")
    public void user_types_in_the_search_box(String excpectBox) {
       etsySearchPage.searchBox.sendKeys(excpectBox);
    }
    @Then("user sees {string} is in the title")
    public void user_sees_is_in_the_title(String excectedTitle) {
       BrowserUtils.verifyTitle(excectedTitle);
    }

}
