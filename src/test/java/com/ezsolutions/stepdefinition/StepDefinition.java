package com.ezsolutions.stepdefinition;

import com.ezsolutions.base.BaseClass;
import com.ezsolutions.pages.LoginPage;
import com.ezsolutions.pages.ProductsPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepDefinition extends BaseClass{

    LoginPage theLoginPage = new LoginPage();
    ProductsPage theProductsPage = new ProductsPage();
    String baseUrl;

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

}
