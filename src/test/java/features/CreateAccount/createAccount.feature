Feature: Creating an account on BBC website

  As a BBC website account user
  I need to be able to create an account
  So that I can access the features available to account users

  @createAccount
  Scenario: User can create an account
    Given I am on the create account page
    When I fill out the required fields
    Then my account should be successfully created

  Scenario: User cannot create an account with an email address already in use
    Given I am on the create account page
    When I fill out the email address field using an already registered email
    Then an error message should display
