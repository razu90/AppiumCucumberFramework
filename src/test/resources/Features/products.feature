Feature: Product Feature

  Scenario Outline: Validate product info on products page
    Given the user is on the product page upon successful Login
    Then validate the product is listed with title "<title>" and price "<price>"
    Examples:
      |title                  |price |
      |Sauce Labs Bolt T-Shirt|$15.99|

  Scenario Outline: Validate product info on product details page
    Given the user is on the product page upon successful Login
    When user clicks on product tile "<title>"
    Then user should be on product details page with title "<title>", price "<price>" and "<description>"
    Examples:
      |title              |price |description                                         |
      |Sauce Labs Backpack|$29.99|carry.allTheThing() with the sleek, streamlined Sly |
