Feature: Feature1

  @Tag1
  Scenario: Scenario 1

    Given user on homepage
    When  user login as follow
      | username | demo |
      | password | demo |
    Then  login should be successfull


  Scenario: Check whether email exist in page
    Given user on customers page
    When user search for email with id 150
    Then email should be listed in the page


  Scenario: Check whether email exist in DB
    Given user on customers page
    When user get email from page with id 312
    Then email should be exist in DB


  Scenario: Fail Scenario
    Given user on employees page
    Then user equate 1 and 2