@Login
Feature: Login as authorized user
Background:
  Given The user navigating to the login page

  Scenario: Login with valid credentials
    Then The user logs in with "correct" credentials
    Then The user is on the "http://zero.webappsecurity.com/bank/account-summary.html" page

  Scenario: Login with invalid credentials
    Then The user logs in with "uncorrect" credentials
    Then The error message is displayed

  Scenario: Login with empty credentials
    Then The user logs in with "empty" credentials
    Then The error message is displayed