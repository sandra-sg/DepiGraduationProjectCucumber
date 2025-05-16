Feature: LandingPage function
  Scenario: Validate That Hot Sellers is displayed and each card contains Price in $
    Given user opens the browser
    And user opens the website URL
    When user scrolls down to Hot Sellers Section
    Then user observe each card should display price in $ and as Double not Integer

  Scenario: Validate That each card contains “Add to Cart” button and clickable
    Given user opens the browser
    And user opens the website URL
    When user scrolls down to Hot Sellers Section
    Then user observe each card should display Add to Cart button and it should be clickable

  Scenario: Validate That Guest user can add product to cart
    Given user opens the browser
    And user opens the website URL
    And user scrolls down to Hot Sellers Section
    When user hover on Card Breathe Easy Tank
    And user Select Size M
    And user select color
    And user Click on Add to Cart button
    Then Product should be added to cart successfully and Cart icon should display number 1