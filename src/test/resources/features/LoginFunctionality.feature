Feature: Login Functionality
  As a user of the EBank App
  I want to be able to log in to my account
  So that I can view my account details

  Scenario: Login with empty input fields

    Given I am on the login page
    When I click on the login button
    Then an error message 'Invalid user ID' should be visible

  Scenario: Login with empty User ID field

    Given I am on the login page
    When I enter a valid PIN
    And I click on the login button
    Then an error message 'Invalid user ID' should be visible

  Scenario: Login with empty PIN field

    Given I am on the login page
    When I enter a valid User ID
    And I click on the login button
    Then an error message 'Invalid PIN' should be visible

  Scenario: Login with invalid inputs

    Given I am on the login page
    When I enter a valid User ID
    And I enter an invalid PIN
    And I click on the login button
    Then an error message 'User ID and PIN didn't match' should be visible

  Scenario: Successful Login

    Given I am on the login page
    When I enter a valid User ID
    And I enter a valid PIN
    And I click on the login button
    Then I should be redirected to the homepage