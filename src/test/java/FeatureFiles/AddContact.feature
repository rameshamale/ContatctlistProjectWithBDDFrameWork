Feature: AddContact functionality

  Scenario: Successful login with valid credentials
    Given The user on login page
    When The user enter valid email
    When The user enter valid loginPassword
    When The user click on submit button
    Then The user redirects on contactListPage
