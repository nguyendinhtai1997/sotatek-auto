@SendFunc
Feature: Send Func

  @SendFunc @MainFunction
  Scenario: Send Token Function
    And user enter passcode "111111"
    And user press function button "Send"
    And user press token "MATIC" network "ERC20"
    And user enter receive address wallet "0x55193ece417fbe85e4343b2c6dd3af49a60bf1b6"
    And user enter amount "1"
    And user enter memo "auto test"
    And user press button "Send"
    And user press button "Cancel"

  @SendFunc @MainFunction
  Scenario Outline: Verify text Send Screen
    And user verify text title "<title>"
    And user verify text network "<network>"
    And user verify text memo "<memoText>"
    Examples:
      | title | network | memoText |
      |       |         |          |