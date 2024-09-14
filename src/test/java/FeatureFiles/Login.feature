Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given The user on login page
    When The user enter valid email
    When The user enter valid loginPassword
    When The user click on submit button
    Then The user redirects on contactListPage

  Scenario: login with invalid email
    Given The user on login page
    When The user enter invalid email
    When The user enter valid loginPassword
    When The user click on submit button
    Then The user error message should display

  Scenario: login with invalid password
    Given The user on login page
    When The user enter valid email
    When The user enter invalid password
    When The user click on submit button
    Then The user error message should display

  Scenario: login with invalid email & password
    Given The user on login page
    When The user enter invalid email
    When The user enter invalid password
    When The user click on submit button
    Then The user error message should display
