Feature: Editing an account

  As a BBC website account holder
  I want to be able to edit my account information
  So that I can update my personal and security information

  Background: User is on their account page
    Given I am on the BBC homepage
    When I sign into my account using my username and password
    Then I should be successfully signed into my account
    And I should be able to view my account information

  Scenario: User can edit their display name
    Given I am on my account page
    When I edit my display name in the Name field
    Then my display name should be updated

  Scenario: User can edit their password
    Given I am on my account page
    When I edit my password in the Password field
    Then my password should be updated

  Scenario: User can edit their gender
    Given I am on my account page
    When I edit my gender in the gender drop down menu
    Then my gender should be updated