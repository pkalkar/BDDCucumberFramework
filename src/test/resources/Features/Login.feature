Feature: Verify Login Functionality

@Sanity
  Scenario: Sucessful login with valid credentials
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User Enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title Should be "Dashboard / nopCommerce administration"
    When User Click on Log out link
    Then Page Title Should be "Your store. Login"
    And close browser
    
@Sanity2
  Scenario Outline: Sucessful login with valid credentials with DDT
    Given User launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User Enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title Should be "Dashboard / nopCommerce administration"
    When User Click on Log out link
    Then Page Title Should be "Your store. Login"
    And close browser

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
      | my@yourstore.com    | admin    |
