Feature: Pay Bills
  
  Background: 
    Given the user is logged in
    And user is navigating to "Pay Bills"
    
    
    Scenario: verify title
      And title should be "Zero - Pay Bills"

      Scenario:

        When user selects Payee "Bank of America" and Account "Checking"