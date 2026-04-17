Feature: Add product to the cart

Scenario:
Add product Sauce Labs Backpack to the cart

Given I am in loggedin to the Application
When I add a product to the cart
Then validate the cart
