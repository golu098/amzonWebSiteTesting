Feature: Validate broken links on Amazon

  Background:
    Given I am on the Amazon homepage
  Scenario: Validate all links on the Amazon homepage

    When I extract all the links from the page
    Then I should see that all links are valid
