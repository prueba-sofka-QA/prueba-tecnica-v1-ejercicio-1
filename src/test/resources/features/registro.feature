Feature: Online Product Purchase
  As a customer
  I want to select and purchase products from the online store
  So that I can receive confirmation of my order with all relevant details

  Scenario Outline: Customer successfully completes a purchase of multiple products
    Given the customer is browsing the product catalog on the home page
    When the customer navigates to the first product
    And the customer sees the first product with
      | Name                | <product_name>   | 
      | Price               | <price_product>  | 
      | Product Description | <description>    | 
    And the customer adds the first product to the cart

    And the customer navigates to the home page
    When the customer navigates to the second product in the catalog
    And the customer sees the second product with
      | Name                | <product_name_2> | 
      | Price               | <price_product_2>| 
      | Product Description | <description_2>  | 
    And the customer adds the second product to the cart
 
    And the customer navigates to the shopping cart
    And the customer reviews the order
    When the customer proceeds to place the order
    And the customer completes the purchase form with 
      | Name        | <customer_name>  | 
      | Country     | <country>        | 
      | City        | <city>           | 
      | Credit Card | <card_number>    |   
      | Month       | <purchase_month> | 
      | Year        | <expiry_year>    |

    And the customer confirms the purchase
    Then the purchase should be confirmed successfully
    And the confirmation should display the purchase details
      | Id          | <order_id>      | 
      | Amount      | <total_amount>  |
      | City        | <city>          | 
      | Card Number | <card_number>   |
      | Name        | <customer_name> |
      | Date        | <purchase_date> |

    Examples:
      | customer_name | country | city     | card_number      | purchase_month | expiry_year | order_id | total_amount | purchase_date |
      | John Smith    | USA     | New York | 4532123456789012 | 12             | 2025        | 12345    | 790          | 14/5/2026     |