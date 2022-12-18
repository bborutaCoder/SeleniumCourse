Feature: HotelRegistration

  Scenario: Registrating new user
    Given User is on main site and sign in clicked
    When User inputs email address and create an account button is clicked
    When User fills in the registration form and register button is clicked
    Then User sees my account page
    And User sees his or her user name