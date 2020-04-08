Feature: Get Pet by ID

  Scenario: User calls web service to get a pet by its id
    Given a pet exists with an id of 1
    When a user retrieves the pet by id
    Then the status code is 200
    And response includes the following
    And the result


  Scenario: User calls web service to get a pet by its id
    Given a pet exists with an id of 2
    When a user retrieves the pet by id
    Then the status code is 200
    And the result

  Scenario: User calls web service to get a pet by its id
    Given a pet exists with an id of 7
    When a user retrieves the pet by id
    Then the status code is 404
    And response includes the following
    And the result

  Scenario: User calls web service to Add a new pet to the store
    Given a user enter pet details
    When POST web services is triggered
    And the status code is 200
    Then GET web services is triggered
    Then compare the Actual with the expected data


   Scenario: User Calls web service to remove and added Pet to the Store
     Given a user enter pet details
     When POST web services is triggered
     And the status code is 200
     Then GET web services is triggered
     And the status code is 200
     Then DELETE web services is triggered
     And the status code is 200
     Then get the pet id and retrive the data
     And the status code is 404







