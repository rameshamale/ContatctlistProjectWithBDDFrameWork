Feature: Delete Contact
  Background:Successful login with valid credentials
    Given The user on login page
    When The user enter valid email
    When The user enter valid loginPassword
    When The user click on submit button
    Then The user redirects on contactListPage

    Scenario: Delete Contact
      Given The user click on any contact
      And The user on contact contactDetailsPage and cliked on delete button
      And The popalert is diplayed and user is clicked on ok button
      Then Verify the contact is deleted

