package com.cydeo.step_definitions;

import com.cydeo.pages.WebTable_LoginPage;
import com.cydeo.pages.WebTable_OrderPage;
import com.cydeo.pages.WebTable_ViewAllOrderPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Map;

public class WebTable_StepDefinitions {

WebTable_LoginPage webTable_loginPage = new WebTable_LoginPage();
    @Given("user is on the Web Table app login page")
    public void user_is_on_the_web_table_app_login_page() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
    }
    @When("user enters correct username")
    public void user_enters_correct_username() {
        webTable_loginPage.inputUserName.sendKeys("Test");
    }
    @When("user enters correct password")
    public void user_enters_correct_password() {
         webTable_loginPage.inputPassword.sendKeys("Tester");
    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webTable_loginPage.loginButton.click();
    }
    @Then("user should see orders word in the URL")
    public void user_should_see_orders_word_in_the_url() {
      String expectedURL= "orders";
      String actiaiURL =Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actiaiURL.contains(expectedURL));
    }


    @When("user enters {string} username and {string} password")
    public void userEntersUsernameAndPassword(String username, String password) {
      webTable_loginPage.inputUserName.sendKeys(username);
      webTable_loginPage.inputPassword.sendKeys(password);
    }

    @When("user enters below correct credentials")
    public void userEntersBelowCorrectCredentials(Map<String,String> credentials) {
      webTable_loginPage.inputUserName.sendKeys(credentials.get("username"));
      webTable_loginPage.inputPassword.sendKeys(credentials.get("password"));
    }



    @Given("user is already logged in to The Web table app")
    public void user_is_already_logged_in_to_the_web_table_app() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        webTable_loginPage.login();

    }

    WebTable_OrderPage orderPage = new WebTable_OrderPage();
    @When("user is on the order page")
    public void user_is_on_the_order_page() {
      orderPage.orderLink.click();
    }
    @Then("user sees below options under product dropdown")
    public void user_sees_below_options_under_product_dropdown(List<String>expectedOptions) {
   List<String> actualOptions = BrowserUtils.dropdownOptions_as_STRING(orderPage.productDropdown);

   Assert.assertEquals(actualOptions,expectedOptions);
    }

/*
task 8
 */

    @Then("user sees Visa as enabled payment option")
    public void user_sees_visa_as_enabled_payment_option() {

        Assert.assertTrue(orderPage.visaRadioButton.isEnabled());
    }
    @Then("user sees MasterCard as enabled payment option")
    public void user_sees_master_card_as_enabled_payment_option() {

        Assert.assertTrue(orderPage.masterCardRadioButton.isEnabled());
    }
    @Then("user sees American Express as enabled payment option")
    public void user_sees_american_express_as_enabled_payment_option() {

        Assert.assertTrue(orderPage.americanExpressRadioButton.isEnabled());
    }



    @And("user enters quantity {string}")
    public void userEntersQuantity(String quantity) {

        orderPage.inputQuantity.clear();

        //another option as deleting whatever already in the input box
        //orderPage.inputName.sendKeys(Keys.BACK_SPACE);

        orderPage.inputQuantity.sendKeys("2");

    }

    @Then("user clicks to the calculate button")
    public void userClicksToTheCalculateButton() {

        orderPage.calculateButton.click();

    }

    @And("user enters customer name {string}")
    public void userEntersCustomerName(String name) {

        orderPage.inputName.sendKeys(name);

    }

    @And("user enters street {string}")
    public void userEntersStreet(String street) {

        orderPage.inputStreet.sendKeys(street);

    }

    @And("user enters city {string}")
    public void userEntersCity(String city) {

        orderPage.inputCity.sendKeys(city);

    }

    @And("user enters state {string}")
    public void userEntersState(String state) {

        orderPage.inputState.sendKeys(state);

    }

    @And("user enters zip {string}")
    public void userEntersZip(String zip) {

        orderPage.inputZip.sendKeys(zip);

    }

    @And("user selects payment option {string}")
    public void userSelectsPaymentOption(String expectedCardType) {

        BrowserUtils.clickRadioButton(orderPage.cardTypes, expectedCardType);

    }

    @And("user enters credit card number {string}")
    public void userEntersCreditCardNumber(String cardNumber) {

        orderPage.inputCreditCard.sendKeys(cardNumber);

    }

    @And("user enters expiration date {string}")
    public void userEntersExpirationDate(String expDate) {

        orderPage.inputExpirationDate.sendKeys(expDate);

    }

    @And("user clicks to process order button")
    public void userClicksToProcessOrderButton() {
        orderPage.processButton.click();

    }

    WebTable_ViewAllOrderPage viewAllOrdersPage = new WebTable_ViewAllOrderPage();

    @Then("user should see {string} in the first row of the web table")
    public void userShouldSeeInTheFirstRowOfTheWebTable(String expectedName) {

        String actualName = viewAllOrdersPage.newCustomerCell.getText();

        Assert.assertEquals(actualName, expectedName);

    }
}
