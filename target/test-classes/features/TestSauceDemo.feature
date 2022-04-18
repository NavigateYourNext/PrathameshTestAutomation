Feature: Test SauceDemo Features

  @Sanity1
  Scenario: Test login page availability
    Given User should have SauceDemo url
    When  User should be navigated to the SauceDemo url
    Then The Page title of login page should be "Swag Labs"
    And User close the browser

  @Sanity @Functional @Regression
  Scenario: Check login functionality of SauceDemo webapp
    Given User must be present on login page
    When User enters username
    And User enters password
    And User clicks on Login button
    Then User must be on "PRODUCTS" page
    And User close the browser