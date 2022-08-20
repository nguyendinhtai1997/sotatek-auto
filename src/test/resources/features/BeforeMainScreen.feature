@BeforeMainScreen
Feature: Before Main Screen

  Background:
    Given user launch app
    When user press button "Get start"

  @CreateAccount
  Scenario: Tạo tài khoản mới
    And user press button "Create new 3S wallet"
    And user tap checkbox to agree TC
    And user press button "Continue"
    And user enter passcode "111111"
    And user enter passcode "111111"
    And user press button "Finish"

  @AlreadyHaveAccount
  Scenario Outline: Sai Seed Phrase
    And user press button "I already have a wallet"
    And user enter seed phrase "<seedPhrase>"
    And user enter wallet name "<walletName>"
    And user press button "Import Wallet"
    Then verify all text displayed in error popup "<title>" "<content>" "<textBtn>"
    Examples:
      | seedPhrase                                                                       | walletName | title | content           | textBtn   |
      | mind process hurry require buld expect pyramid science fame fringe shuffle empty | Auto Test  | Error | Word phrase Error | Try again |

  @AlreadyHaveAccount
  Scenario Outline: Đúng Seed Phrase
    And user press button "I already have a wallet"
    And user enter seed phrase "<seedPhrase>"
    And user enter wallet name "<walletName>"
    And user press button "Import Wallet"
    And user enter passcode "111111"
    And user enter passcode "111111"
    And user press button "Finish"
    Then verify greeting displayed
    Examples:
      | seedPhrase                                                                   | walletName |
      | swift you craft online promote charge reason hold blanket client park parrot | Auto Test  |