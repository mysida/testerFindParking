Feature: Basic

Scenario: Search for parking
Given user is on first page
When user searches for "Odinsgatan"
Then user sees a list of parking optiona near "Odinsgatan"

Scenario: show map
Given that the user has search results
Then user can bring up map

Scenario: Login
When user login
Then user sees his sida