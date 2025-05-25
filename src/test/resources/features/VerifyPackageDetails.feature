Feature: Package Details

  @smoke
  Scenario: User is able to see package details
    Given user opens the application
    Then user is on "Store" page
    When user searches for "Japan"
    And user selects the "Japan" destination from the "Local" section
    Then user is on "Japan" store page
    When user selects to buy the 1 purchasable result
    Then user is on "Package Detail" component
    And user is on the 1 "Japan" package details page
