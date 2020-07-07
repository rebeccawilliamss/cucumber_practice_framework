Feature: Accessing local news

  As a BBC website user
  I want to be able to access the local news page
  So that I can read the news from my local area

  @localNews
  Scenario: Checking news in a local area
    Given I am on the local news page
    When I type Andover into the search bar
    Then I should be taken to the local news page for Andover
