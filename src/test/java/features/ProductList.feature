Feature: Fetch the product list from Amazon and Flipkart

  @amazon
  Scenario Outline: Fetch product list from Amazon.in
    Given User has navigated to "amazon.in" homepage
    When User enters the keyword "<keyword>" in search-box
    And Presses the Search button
    Then Search result should contain correct product list

    Examples:
    | keyword |
    | phone |
   # | laptop |

  @flipkart
  Scenario Outline: Fetch product list from flipkart.com
    Given User has navigated to "flipkart.com" homepage
    When User enters the keyword "<keyword>" in search-box
    And Presses the Search button
    Then Search result should contain correct product list

    Examples:
      | keyword |
      | phone |
      | laptop |