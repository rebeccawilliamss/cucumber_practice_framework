#// Training purposes only!!
#// CHANGE PASSWORDS BEFORE TESTING OR TEST WILL NOT WORK
#// TEST is a placeholder

Feature: Sign in functionality for the BBC website

  As a BBC website user
  I want to log into my BBC account
  So that I can use the BBC account features

  @login
  Scenario Outline: User can login with the correct credentials
    Given I am on the Login page
    When I enter my <username> and <password>
    Then I should be signed in and returned to the Homepage

    Examples:
    | username                         | password    |
    | "rebecca.williams18@yahoo.co.uk" | "TEST" |
    | "becca18xx@yahoo.co.uk"          | "TEST" |

  @logout
  Scenario: User can logout of their account
    Given I am logged into my BBC website account
    When I click the logout button
    Then I should be successfully logged out of my account

  @Delete
  Scenario: User can delete their account
    Given I am logged into my BBC website account
    When I select to delete my account
    Then my account should be successfully deleted
