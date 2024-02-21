Feature: Logout Functionality
  As a user of the EBank App
  I want to be able to log out of my account
  So that I can login again when it need

  Scenario: Successful logout

    Given I am on the login page
    When I enter a valid User ID
    And I enter a valid PIN
    And I click on the login button
    And I click the Logout button of the Home page
    Then I should be redirected to the login page