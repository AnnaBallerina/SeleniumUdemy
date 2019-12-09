#Each feature contains one feature
#Feature files use Gherkin language - business language
Feature: Test the login functionality on sdet university
  #The feature may have given different specific scenarios
  #Scenarios use Given-When-Then structure
#  Scenario: the user should be able to login with correct username and correct password
#    Given user is on the login page
#    When user enters correct username and correct password
#    Then user gets confirmation
#
  Scenario Outline: the user should be able to login
    Given user is on the login page
    When user enters email <username>
    And user enters password <password>
    Then user gets confirmation
    Examples:
    | username | password |
    |tim@testmail.com|trpass|
    |ml@testemail.com|ml3password|
    |jv@testemail.com|jv4password|