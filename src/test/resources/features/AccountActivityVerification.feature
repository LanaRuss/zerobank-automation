Feature: Account Activity verification

  Background:
    Given the user is logged in
    When user is navigating to "Account Activity"


  Scenario: verify title
    Then title should be "Zero – Account activity"

  Scenario: Account dropdown default option should be Savings
    Then account dropdown default option should be "Savings"


  Scenario: Account Dropdown Options
    Then account drop down should have the following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  @wip
  Scenario: Transaction Table names
    Then the user accesses the Find Transactions tab
    Then clicks search
    Then transactions table should have column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |