@Multiple
Feature: Login
Scenario: Login using valid credentials
Given the url is "https://www.saucedemo.com/"
When the username entered is "<username>"
And the password entered is "<password>"


Examples:
|username|password|
|standard_user|secret_sauce|
|admin123|Admin|
|admin|manager|