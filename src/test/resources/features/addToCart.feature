Feature: Add multiple products to the cart on Amazon

  As a registered or guest user
  I want to add multiple products to my cart
  So that I can review them before making a purchase

  Background:
    Given I am on the Amazon home page

  @AddToCart
  Scenario: Add multiple products to the cart successfully
    Given I add the following products to the cart:
      | Product Name       | Quantity |
      |Samsung Galaxy M15     | 1        |
      | iPhone 14          | 1        |
      | Sony WH-1000XM5    | 1        |


    When I navigate to the cart page
#    Then I should see all the added products in the cart:
#      | Product Name       | Quantity |
#      |Samsung Galaxy M15     | 1        |
#      | iPhone 14          | 1        |
#      | Sony WH-1000XM5    | 1        |

#    And the total number of items in the cart should be 3
