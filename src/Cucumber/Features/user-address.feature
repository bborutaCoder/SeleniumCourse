Feature: User addresses

Scenario Outline:  Add the address to user account

Given user logins to previously created account with details "<email>", "<password>"
When user goes to addresses - URL
And clicks on new address
  Then user fills New address with "<alias>", "<address>", "<city>", "<zip>", "<country>", "<phone>"
And checks if data in New address contains proper details "<alias>", "<address>", "<city>", "<zip>", "<country>", "<phone>"

  Examples:
  |email|password|alias|address|city|zip|country|phone|
  |sk8_flojd@wp.pl|Piccolo666|ChosenOne|Baklazanowa 66|Gdansk|80-410|United Kingdom|123456789|
