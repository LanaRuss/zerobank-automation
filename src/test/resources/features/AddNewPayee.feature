Feature: Add new payee under pay bills

  Background:
    Given the user is logged in

  Scenario Outline: Add a new payee
    Given user is navigating to "Pay Bills"
    And go to "Add New Payee" tab
    And create new payee using following information
      | Payee Name    | <name>    |
      | Payee Address | <adress>  |
      | Account       | <account> |
      | Payee details | <details> |

    Then message "The new payee <name> was successfully created." should be displayed

    Examples: data
      | name                                      | adress                          | account     | details     |
      | The Law Offices of Hyde , Price & Scharks | 100 Samest, Anytown, USA, 10001 | Checking    | XYZaccount  |
      | Lana                                      | 2276 E                          | savings     | no details  |
      | Andrii                                    | 4023 r                          | card credit | bla bla bla |