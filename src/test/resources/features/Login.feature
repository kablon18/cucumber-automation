@login-user
  Feature: User Login

    Scenario: User Login - Successful
      Given user navigates to webdriver university login page
      When user enters username webdriver
      And user enters password webdriver123
      And user clicks on login button
      Then user should receive a successful login pop-up message - 'validation succeeded'
