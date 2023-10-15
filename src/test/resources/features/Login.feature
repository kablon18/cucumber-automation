@login-user
  Feature: User Login

    Background:
      Given user navigates to webdriver university login page

    Scenario Outline: Validate - Successful and Unsuccessful Login
      When user enters username <username>
      And user enters password <password>
      And user clicks on login button
      Then user should receive a login pop-up message "<validationText>"

      Examples:
        | username | password     | validationText       |
        | webdriver| webdriver123 | validation succeeded |
        | webdriver| webdriver1   | validation failed    |
