@Zomato
Feature: Search restaurants
Scenario: Search for restaurant and fetch the distance and duration
Given User should trigger "https://www.zomato.com" in browser
When User clicks on zomato restaurant link
Then Zomato dashboard should be displayed
When he searches for "Meghana Foods"
Then Restaurant list should be displayed
When he selects the first option
Then Restaurant page should be displayed
When he clicks on direction link
Then It should be navigated to google maps 
Then Duration and distance should be displayed
