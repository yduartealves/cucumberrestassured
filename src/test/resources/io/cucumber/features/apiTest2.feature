@apiEndPointTest2
Feature: To verify JSON response from the given api endpoint
  Scenario: To verify the given api end and its response parameters using GET method
    Given I want to initialise the end point
    When I want to hit the end point
    Then I should get the response
    Then I should validate the Json properties
