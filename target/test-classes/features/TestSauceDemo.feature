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

  @Functional @Regression
  Scenario: Purchase the product with maximum price
    Given User must be present on "PRODUCTS" page
    When User select maximum price product
    Then User goes to the cart and verifies the added product
    And User checkout the cart
    And User add the details like First Name as "Prathamesh" Last Name as "Kulkarni" and Postal Code as "411015"
    And User does the checkout review
    And User clicks on Finish
    And User gets final message as "THANK YOU FOR YOUR ORDER"
    And User close the browser


