Feature: unit conversor application

  @Test1
  Scenario: Validate Info and Pagination data: Count
    Given I want to test rick and morty data
    When  I count displayed characters
    Then  The value in the pagination is the same

  @Test2
  Scenario: Validate Info and Pagination data: Prev and Next
    Given I want to test rick and morty data
    When  I go over the navigation pages
    Then  The navigation shows valid values

  @Test3
  Scenario: Validate Info and Pagination data: no page found
    Given I want to test rick and morty data
    When  I go over a non-existent page
    Then  The result will be There is nothing here and 404