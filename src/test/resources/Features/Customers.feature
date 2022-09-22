Feature: Verify Add New Customer Functionality

  Background: 
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User Enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    
@Sanity1
  Scenario: Add New Customer
    Then User can view Dashboard
    When User click on customers Menu
    And Click on customers Menu Item
    And Click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And Click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser
