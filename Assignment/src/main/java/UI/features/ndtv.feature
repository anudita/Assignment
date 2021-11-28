@test
Feature: Verify Home page functionalities for NDTV website

  Background:
    Given User opens NDTV
     And Allows all alerts on the page

    Scenario: Subscribe to news updates on NDTV
      When User clicks on bell icon
      Then User should see a popup box with text as:
      | Text | You have subscribed to our news updates. To unsubscribe, |
      And User clicks on close button