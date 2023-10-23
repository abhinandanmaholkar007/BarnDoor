Feature: Barn and Horses module

  Background:
    Given the user is on the login page

  Scenario: Successful Login with valid credentials
    When user login with valid credential userName as "abhi@yopmail.com" and password "Abhi@007"
    Then verify dashboard URL "https://stg.barndoor.tech/dashboard"

   Scenario: Add new Barn
    When user login with valid credential userName as "abhi@yopmail.com" and password "Abhi@007"
     Then enters the barn name "barn20" and Number of Stalls as "4"
     Then clicks on the save button and extract barn confirmation message

  Scenario: Add new pasture
    When user login with valid credential userName as "abhi@yopmail.com" and password "Abhi@007"
    Then add pasture "pasture-1" and extract confirmation message

  Scenario: Add new Horse
    When user login with valid credential userName as "abhi@yopmail.com" and password "Abhi@007"
    Then Clicks on the barn and horse icon and add horse "Horse-07"

  Scenario: Search Horse
    When user login with valid credential userName as "abhi@yopmail.com" and password "Abhi@007"
    Then Clicks on the barn and horse icon and search horse "Badal"
    Then Searched horse should be populated


