Feature: AddUser
  Scenario: Add Valid user
    Given The user on login page
    When The user click on SignUpButton
    When The user redirect on AddUserPage
    When The user enter FirstName
    When The user enter LastName
    When The user enter email
    When The user enter password
    When The user click on SignUp Button
    Then The user redirects on contactListPage




