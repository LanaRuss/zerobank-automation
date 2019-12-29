
Feature: Purchase Foreign Currency

Background:
  Given the user is logged in
  Then user is navigating to "Pay Bills"
  And go to "Purchase Foreign Currency" tab


  Scenario: Available currencies
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |


  Scenario: Error message for not selecting currency
    And user enters amount 400
    When user tries to calculate cost without "selecting a currency"
    Then error message should be displayed


  Scenario: Error message for not entering value

    And user choses currency "Canada (dollar)"
    When user tries to calculate cost without "entering a value"
    Then error message should be displayed