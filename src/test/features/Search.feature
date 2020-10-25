Feature: As a user
         I should do search

  @search
  Scenario: Validate search results

    Given I'm on google home page
    When I enter searchTerm "Books"
    And I click searchButton
    Then I should get appropriate search results that contains text "Books"