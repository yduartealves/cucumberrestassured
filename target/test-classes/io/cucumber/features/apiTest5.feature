@apiTest5, @apiTests
Feature: To check if the given invalid user is not authorised in reqres site
  Scenario: To check invalid user is not authorised using POST method
    Given I want to enter the invalid user
    When I submit my invalid "peter@klave" request
    Then I should get error with 400 response



