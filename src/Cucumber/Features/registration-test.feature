Feature: HotelRegistration

  Scenario Outline: Registrating new user
    Given User is on main site and sign in clicked
    When User inputs email address and create an account button is clicked
    When User fills in the registration form with <firstName>, <lastName>, <password> and register button is clicked
    Then User sees my account page
    And User sees its name <firstName>

    Examples:
    |firstName|lastName|password|
    |Michal   |Dawidows|qwerty  |