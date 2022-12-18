Feature: Google search

  Scenario Outline: user can search any keyword
    Given an open browser with google.com
    When a keyword <keyword> is entered in input field
    Then the first result should contain <keyword>
    And close browser

    Examples:
    |keyword  |
    |selenium |
    |java     |
    |c#       |