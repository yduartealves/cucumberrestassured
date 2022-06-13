@apiEndPointTest3
Feature: To verify the api end point response when invalid key is passed
  Scenario: To verify the api invalid 403 response GET method
    Given I want to enter the request for user
    When I submit my request with invalid key
    Then I should get Unsuccessful response
    Then I should get the requestId
