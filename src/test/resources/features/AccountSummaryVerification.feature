Feature: Account summary verification

  Background:
    Given the user is logged in

  Scenario: Verify title
    Given The user is on the "http://zero.webappsecurity.com/bank/account-summary.html" page
    Then title should be "Zero - Account Summary"

  Scenario: Verify account types
    Given The user is on the "http://zero.webappsecurity.com/bank/account-summary.html" page
    Then Account summary page should have the following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario:
    Given The user is on the "http://zero.webappsecurity.com/bank/account-summary.html" page
    Then Credit accounts table must have colums
      | Account     |
      | Credit Card |
      | Balance     |

