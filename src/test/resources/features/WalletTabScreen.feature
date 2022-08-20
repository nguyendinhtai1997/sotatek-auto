@WalletTabScreen
Feature: Wallet Tab Screen

#  Chạy khi reset app
#  @VerifyWalletTab @ResetApp
#  Scenario: Verify Wallet Tab
#    When user press button "Get start"
#    And user press button "I already have a wallet"
#    And user enter seed phrase "swift you craft online promote charge reason hold blanket client park parrot"
#    And user enter wallet name "Auto Test"
#    And user press button "Import Wallet"
#    And user enter passcode "111111"
#    And user enter passcode "111111"
#    And user press button "Finish"
#    Then verify greeting displayed
#    Then verify all text displayed on Wallet Tab

#  Chạy khi k reset app
  @VerifyWalletTab @NoResetApp
  Scenario: Verify Wallet Tab
    And user enter passcode "111111"
    Then verify greeting displayed
    Then verify all text displayed on Wallet Tab

  @SendToken @MainFunction
  Scenario: Send Token Function
    And user press function button "Send"
    And user press token "BUSD" network "BEP20"

  @ReceiveToken @MainFunction
  Scenario: Receive Token Function
    And user press back
    And user press back
    And user press function button "Receive"

  @BuyToken @MainFunction
  Scenario: Buy Token Function
    And user press back
    And user press function button "Buy"

  @SwapToken @MainFunction
  Scenario: Swap Token Function
    And user press back
    And user press function button "Swap"

  @CopyAddress @MainFunction
  Scenario: Copy Address Function
    And user press back
    And user press icon coppy
    And user verify text after copy address

  @HideBalance @MainFunction
  Scenario: Hide/unHide Balance Function
    And user press icon hide balance
    And user verify value after hide balance
    And user press icon unHide balance
    And user verify value after unHide balance

  @ChangeTheme @MainFunction
  Scenario: Change Theme Function
    And user press icon change theme

    @SwicthWallet @MainFunction
      Scenario: Switch Wallet Function
      And user switch to second wallet
      And user switch to first wallet

