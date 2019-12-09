#Each feature contains one feature
#Feature files use Gherkin language - business language
Feature: Test the login functionality on sdet university

#The feature may have given different specific scenarios
#Scenarios use Given-When-Then structure
Scenario: the user should be able to login with correct username and correct password
  Given user is on the login page
  When user enters correct username and correct password
  Then user gets confirmation