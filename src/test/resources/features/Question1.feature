@Question1
Feature: Question 1

  Scenario: Test “Create Project”
    Given Create test project via API
    And Login into mobile application
    Then Verify on mobile that project is created

  Scenario: Test “Create Task via mobile phone”
    Given Create test task via mobile application in test project
    Then Verify that task created correctly

  Scenario: Test “Reopen Task”
    And Open test project
    And Created test task
    And Complete test task
    And Reopen test task via API
    Then Mobile: Verify that test task appears in your test project
