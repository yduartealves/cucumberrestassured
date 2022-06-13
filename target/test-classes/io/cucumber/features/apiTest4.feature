@apiTest4, @apiTests
Feature: To create new user to the regres site
  Scenario: To create a new user to the regres database using POST method
    Given I want to enter the new user
    When I submit my new user request
    Then I should get user created 201 response