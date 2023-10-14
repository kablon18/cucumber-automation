@contact-us
Feature: WebDriver University - Contact Us Page

  Scenario: Validate Successful Submission - Unique Data
    Given user access webdriver university contact us page
    When user enters unique first name
    And user enters unique last name
    And user enters unique email address
    And user enters unique comments
    And user clicks on submit button
    Then user should be redirected to page with success message

  Scenario: Validate Successful Submission - Specific Data
    Given user access webdriver university contact us page
    When user enters a specific first name Kevin
    And user enters a specific last name - Ablon
    And user enters a specific email address - kevinablon@mailtest.com
    And user enters a specific comment - "My Name is Kevin Makulit"
    And user clicks on submit button
    Then user should be redirected to page with success message
