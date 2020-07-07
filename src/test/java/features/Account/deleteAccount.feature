Feature: Deleting an account from the BBC website

  As a registered BBC account holder
  I want to be able to delete my account
  So that I no longer have access to the account features

  Scenario: User can delete their account
    Given I am on my account page
    When I click on the link to delete my account
    Then my account should be successfully deleted