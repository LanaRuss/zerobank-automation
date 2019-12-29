Feature: Add new payee under pay bills

  Background:
    Given the user is logged in


  Scenario: Add a new payee
    Given user is navigating to "Pay Bills"
    And go to "Add New Payee" tab
    And create new payee using following information
      | Payee Name    | The Law Offices of Hyde , Price & Scharks |
      | Payee Address | 100 Samest, Anytown, USA, 10001           |
      | Account       | Checking                                  |
      | Payee details | XYZaccount                                |

    Then message "The new payee The Law Offices of Hyde , Price & Scharks was successfully created." should be displayed