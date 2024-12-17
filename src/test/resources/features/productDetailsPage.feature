Feature: Product Detail page

  Scenario Outline: Validate product details for multiple products
    Given I navigate to the Amazon home page
    When I search for a product with the name "<productName>"
    And I select the first product from the search results containing "<productName>"
    Then I should see the product name containing "<productName>"
    And the price should be displayed



    Examples:
      | productName            |
      | Samsung Galaxy S23     |
      | Apple iPhone 15        |
#      | OnePlus 11             |
#      | Sony WH-1000XM5        |
#      | Dell XPS 15            |
