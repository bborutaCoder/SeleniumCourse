Feature: User addresses

  Scenario Outline: Add first address
    Given registered user on the "https://hotel-testlab.coderslab.pl/en/login?back=addresses" page
    And user is logged in with email "<email>" and password "<password>"
    When user click Add a New Address button
    When user fills in new address form with "<street>", "<postalCode>", "<city>", "<country>", "<phone>", "<title>" user clicks Save button
#    Then

  Examples:
    |email          |password|street      |postalCode |city     |country|phone    |title      |
    |johnd@mail.com |qwerty  |Sezamkowa 12|00-001     |Warszawa |Poland |21376666 |Moj adres 1|