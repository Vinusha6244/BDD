@Multiple
Feature: Login Feature
Scenario: Login using valid credentials
Given User should be present in "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When he enters the username as "<username>"
And he enters the password as "<password>"
And he clicks on login button
Then Dashboard page should be displayed

Examples:
|username|password|
|Admin|admin123|
|admin123|Admin|
|admin|manager|