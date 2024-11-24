Feature: Search functionality on Amazon

  As a user of the Amazon website
  I want to search for specific products
  So that I can validate search results and use sorting and filtering options effectively

  Background:
    Given I am on the Amazon home page

  Scenario: Search for a product and validate search results
    When I search for a product "laptop"
    Then I should see search results containing the keyword "laptop"
    And the total number of results should be displayed
#
#  Scenario: Verify sorting options in search results
#    Given I search for a product "mobile"
#    When I apply the sorting option "Price: Low to High"
#    Then the products should be displayed in ascending order of price
#
#  Scenario: Verify filtering options in search results
#    Given I search for a product "laptop"
#    When I apply the filter for "Brand: HP"
#    Then only products from the brand "HP" should be displayed
