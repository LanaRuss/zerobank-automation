@Login
Feature: Login as authorized user

  Scenario: Login with valid credentials
    Given The user navigating to the login page
    Then The user logs in with "correct" credentials
    Then The user is on the "Account summary" page


  Scenario: Login with invalid credentials
    Given The user navigating to the login page
    Then The user logs in with "uncorrect" credentials
    Then The error message is displayed
@wip
  Scenario: Login with empty credentials
    Given The user navigating to the login page
    Then The user logs in with "empty" credentials
    Then The error message is displayed