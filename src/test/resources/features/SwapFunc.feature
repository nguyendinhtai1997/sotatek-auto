@SwapFunc
Feature: Send Func

  @SwapFunc @MainFunction
  Scenario: Swap Function
    And user change slippage to 5%
    And user press button "Save"
    And user choose chain "BNB Main Network"
    And user get max value can swap
    And user set value to swap random smaller maximum
    And user press button "Swap"
    And user verify transfer confirm
    And user press button "Confirm"

  @SwapFunc @MainFunction
  Scenario: Swap without amount
    And user press button "Swap"
    And user verify popup warning

  @SwapFunc @MainFunction
  Scenario: Cross-chain Function
    And user choose "BNB Main Network"
    And user get max balance
    And user set amount 14
    And user press button "Send"

  @SwapFunc @MainFunction
  Scenario: Cross-chain without amount
    And user press button "Send"
    And user verify popup warning