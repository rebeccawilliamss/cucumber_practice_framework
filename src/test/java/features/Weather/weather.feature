Feature: Testing functionality on Weather pages
  As a user
  I want to be able to check the weather in areas of my choice
  So that I can plan my day accordingly

  @Weather
  Scenario: Checking the weather in local area
    Given I am on the Weather Page
    When I type "Andover" into the search bar
    And I select the correct area from the drop down list
    Then I should be taken to the page displaying the Weather for Andover

  @Weather
  Scenario: Testing the weather sliding bar
    Given I am on the Weather Page
    And I have searched for the weather in "Andover"
    When I click and drag the sliding bar to view the weather forecast
    Then I should be able to see the weather for the rest of the day