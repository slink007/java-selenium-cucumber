Feature: search and place the order for products

Scenario Outline: search experience should be same for both home and offers page

Given user is on GreenKart landing page
When user searched with short name <Name> and extracted actual product name
Then user searched for same short name <Name> on offers page to check if product exists

Examples:
| Name |
| tom  |
| beet |