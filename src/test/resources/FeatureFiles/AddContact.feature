Feature: AddContact functionality

  Background: Successful login with valid credentials
    Given The user on login page
    When The user enter valid email
    When The user enter valid loginPassword
    When The user click on submit button
    Then The user redirects on contactListPage

  Scenario: When the user enter valid details contact should be created
    Given The user click on Add a new contact button
    When The user enter valid creadentils
    Then The new contatc is displayed in contactList table

  Scenario: When the user enter invalid details contact should be not created
    Given The user click on Add a new contact button
    When The user enter invalid creadentils
    Then The invalidemail error message should be display