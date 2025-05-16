Feature: Wishlist function
  Scenario: Guest user can’t add any product to Wishlist
    Given user open the browser
    And user open the website URL
    And user scroll down to Hot Sellers Section
    When user hover on any card
    And user click on Add to Wishlist button
    Then user should be navigated to login page

  Scenario: Logged in user can add any product to Wishlist
    Given user open the browser
    And user open the website URL
    And user log in successfully
    And user scroll down to Hot Sellers Section
    When user hover on any card
    And user click on Add to Wishlist button
    Then user should be navigated to My Wishlist page with the same product added to Wishlist from landing page

