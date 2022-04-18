Feature: Test SauceDemo Features

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

@Sanity
Scenario: Check the error UI message presence
Given User must be present on login page
When The error message displayed
Then User close the browser