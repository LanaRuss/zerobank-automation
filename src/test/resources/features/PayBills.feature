Feature: Pay Bills

  Background:
    Given the user is logged in
    And user is navigating to "Pay Bills"


  Scenario: verify title
    And title should be "Zero - Pay Bills"

  Scenario: successful payment
    When user filles up Pay Saved Payee form with following data

      | Payee       | Bank of America      |
      | Account     | Checking             |
      | Amount      | 2500                 |
      | Date        | 2020-01-21           |
      | Description | For testing purposes |

    Then message "The payment was successfully submitted." should be displayed

  Scenario Outline: Verify <field> field can not take:
    When user enters "<inputs>" into "<field>" input field
    Then "<field>" input field should be empty


  Examples: date
    | inputs | field  |
    | abcd   | date   |
    | $%^    | date   |

  Examples: amount
    | inputs | field  |
    | abcdd  | amount |
    | *&^    | amount |
