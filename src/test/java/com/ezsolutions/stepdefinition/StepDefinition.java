package com.ezsolutions.stepdefinition;

import com.ezsolutions.base.BaseClass;
import com.ezsolutions.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepDefinition extends BaseClass{

    String baseUrl;
    LoginPage theLoginPage = new LoginPage();
    ProductsPage theProductsPage = new ProductsPage();
    YourCartPage theYourCartPage = new YourCartPage();
    YourInformationPage theYourInformationPage = new YourInformationPage();
    OverViewPage theOverViewPage = new OverViewPage();
    CompletePage theCompletePage = new CompletePage();


    /*@After
    public void closeBrowser(){
        driver.close();
    }*/

    @Given("User should have SauceDemo url")
    public void user_should_have_sauce_demo_url() {
        baseUrl = theProperties.getProperty("baseUrl");
    }
    @When("User should be navigated to the SauceDemo url")
    public void user_should_be_navigated_to_the_sauce_demo_url() {
        String browserName = theProperties.getProperty("browserName");
        driver = loadWebDriver(browserName);
    }
    @Then("The Page title of login page should be {string}")
    public void the_page_title_of_login_page_should_be(String theExpectedPageTitle) {
        String pageTitle = theLoginPage.getPageTitle();
        Assert.assertEquals(pageTitle, theExpectedPageTitle);
    }
    @Then("User close the browser")
    public void user_close_thr_browser(){
        closeBrowser();
    }

    @Given("User must be present on login page")
    public void user_must_be_present_on_login_page() {
        String browserName = theProperties.getProperty("browserName");
        driver = loadWebDriver(browserName);
    }
    @When("User enters username")
    public void user_enters_username() {
        theLoginPage.enterUserName(theProperties.getProperty("username"));
    }
    @When("User enters password")
    public void user_enters_password() {
        theLoginPage.enterPassword(theProperties.getProperty("password"));
    }
    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        theProductsPage = theLoginPage.clickLoginButton();
    }
    @Then("User must be on {string} page")
    public void user_must_be_on_page(String theExpectedPageTitle) {
        String pageTitle = theProductsPage.getTitle();
        Assert.assertEquals(pageTitle, theExpectedPageTitle);
    }

    @Given("User must be present on {string} page")
    public void user_must_be_present_on_page(String theExpectedPageTitle) {
        String browserName = theProperties.getProperty("browserName");
        driver = loadWebDriver(browserName);
        theLoginPage.enterUserName(theProperties.getProperty("username"));
        theLoginPage.enterPassword(theProperties.getProperty("password"));
        theProductsPage = theLoginPage.clickLoginButton();
        String pageTitle = theProductsPage.getTitle();
        Assert.assertEquals(pageTitle, theExpectedPageTitle);

    }
    @When("User select maximum price product")
    public void user_select_maximum_price_product() {
        theProductsPage.selectMaximumPriceProduct();
    }

    @Then("User goes to the cart and verifies the added product")
    public void user_goes_to_the_cart_and_verifies_the_added_product() {
        theYourCartPage = theProductsPage.goToShoppingCart();
        boolean result = theYourCartPage.verifyTheAddedProduct();
        Assert.assertTrue(result);
    }
    @Then("User checkout the cart")
    public void user_checkout_the_cart() {
        theYourInformationPage = theYourCartPage.checkoutProduct();
    }
    @Then("User add the details like First Name as {string} Last Name as {string} and Postal Code as {string}")
    public void user_add_the_details_like_first_name_as_last_name_as_and_postal_code_as(String firstName, String lastName, String postalCode) {
        theOverViewPage = theYourInformationPage.enterUserPersonalDetails(firstName,lastName,postalCode);
    }
    @Then("User does the checkout review")
    public void user_does_the_checkout_review() {
        boolean result = theOverViewPage.doCheckoutReview();
        Assert.assertTrue(result);
    }
    @Then("User clicks on Finish")
    public void user_clicks_on_finish() {
        theCompletePage = theOverViewPage.clickFinishButton();
    }
    @Then("User gets final message as {string}")
    public void user_gets_final_message_as(String theExpectedMessage) {
        String actualMessage = theCompletePage.verifyFinalMessage();
        Assert.assertEquals(actualMessage,theExpectedMessage);
    }


}
