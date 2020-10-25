Feature: As a user
  I should save products for future purchase


  Scenario: Validate SavedList redirection from home page header

    Given I'm on homepage
    When I click savedList Icon
    Then I should redirected to the saved lists page with text as "You have no Saved Items"

@smoke
  Scenario Outline: Add more Items to bag

    Given I'm on homepage
    When I search using "<searchTerm>"
    And I choose a product "<productName>"
    And I select size "<size>"
    And click add to bag
    Then the product "<productName>"should be in the bag

    Examples:
      | searchTerm | productName     | size |
      | T-Shirt    | White T-shirt   | 8    |
      | Jeans      | Black T-shirt   | S    |
      | Joggers    | Printed Joggers | M    |

