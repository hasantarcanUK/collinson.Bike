
Feature: Verification of Frankfurt in Germany

Scenario: As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude
    Given finding body index of Frankfurt
    When  verify country of Frankfurt
    Then  print out latitude and longitude of Frankfurt


