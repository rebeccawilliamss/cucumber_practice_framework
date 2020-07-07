Feature: HomePageQuickSearch
  As a BBC site user
  I want to be able to make a quick search on the Homepage
  So that I can easily find what I am looking for

  @QuickSearch_01
  Scenario: check results for search term "coronavirus"
    Given that I am on the BBC Homepage
    When I type "coronavirus" into the search box
    And I click on the search icon
    Then I am taken to that result page