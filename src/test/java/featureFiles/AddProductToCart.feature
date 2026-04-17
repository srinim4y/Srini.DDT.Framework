Feature: Add product To Cart
 
  @Smoke
  Scenario: Add product to Cart
    When Click on product "Sauce Labs Backpack"
    And click on add to cart button
    Then I validate product "Sauce Labs Backpack" in cart page
    
   @Regression 
    Scenario: Add product to Cart With checkout
    When Click on the product "Sauce Labs Bike Light"
    And click on the add to cart button
    And Navigate to Cart Page
    Then Click on Checkout