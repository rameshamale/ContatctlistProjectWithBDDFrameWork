Feature: Edit Contact
Background:Successful login with valid credentials
  Given The user on login page
  When The user enter valid email
  When The user enter valid loginPassword
  When The user click on submit button
  Then The user redirects on contactListPage
  Scenario: Edit firstName
    Given The user click on any contact
    And The user click on edit contact button
    And The user edit the firstName
    When The user click on submit button on contactDetailPage
    Then Verify the firstName is changed




