Feature: Place the order for Products

@PlaceOrder
Scenario Outline: Search experience for product search in both home and checkout page

Given user is on GreenKart landing page
When user searched with short name <Name> and extracted actual product name
And Added <Quantity> items of the selected product to cart
Then User proceeds to Checkout and validate the <Quantity> items in checkout page
And verify user has ability to enter promo code and place the order

Examples:
| Name  | Quantity |
| tom 	|    3     |