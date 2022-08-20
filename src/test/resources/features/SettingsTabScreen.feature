@SettingsTabScreen
Feature: Before Main Screen

#  Chạy khi reset app
#  @VerifySettingsTab
#  Scenario: Verify Settings Tab
#    When user press button "Get start"
#    And user press button "I already have a wallet"
#    And user enter seed phrase "swift you craft online promote charge reason hold blanket client park parrot"
#    And user enter wallet name "Auto Test"
#    And user press button "Import Wallet"
#    And user enter passcode "111111"
#    And user enter passcode "111111"
#    And user press button "Finish"
#    And user press button "Settings"
#    Then verify all text displayed on Settings Tab

#  Chạy khi k reset app
  @VerifySettingsTab @BackUpWallet @AddContact
  Scenario: Verify Settings Tab
    And user enter passcode "111111"
    And user press button "Settings"
    Then verify all text displayed on Settings Tab

  @WalletManagement @SettingsFunction
  Scenario: Wallet Management Settings Function
    And user press settings function button "Wallet"
    And user press back

  @WalletManagement @SettingsFunction @BackUpWallet
  Scenario: Wallet Management Settings Function
    And user press settings function button "Wallet"
    And user add new wallet
    And user press button "Create new 3S wallet"
    And user press button "Finish"
    And user press button "Settings"
    And user press settings function button "Wallet"
    And user press icon setting new wallet
    And user press back up seed phrase
    And user enter passcode "111111"
    And user accept all checkbox
    And user press back up wallet
    And user press button "View"
    And user press I have copied to somewhere safe
    And user double check phrase
    And user press button "Done"
    And user delete wallet
    And user press button "Settings"
    And user press settings function button "Wallet"
    And user press icon setting new wallet
    And user press button "I already have a wallet"
    And user input seed phrase and wallet name
    And user press button "Import Wallet"
    Then verify greeting displayed

  @WalletManagement @SettingsFunction @RemoveWallet
  Scenario: Remove Wallet Settings Function
    And user delete wallet

  @WalletManagement @SettingsFunction @RemoveWallet
  Scenario: Rename Wallet Settings Function
    And user press settings function button "Wallet"
    And user press icon setting new wallet
    And user clear name wallet
    And user input new name "New name"
    And user press button "Done"
    And user press button "OK"
    And user press back

  @Contacts @SettingsFunction
  Scenario: Contacts Settings Function
    And user press settings function button "Contacts"
    And user press back

  @Contacts @SettingsFunction @AddContact
  Scenario Outline: Contacts Settings Function
    And user press settings function button "Contacts"
    And user press add contact
    And user input "<contact name>" and "<contact address>"
    And user press button "Add"
    Examples:
      | contact name | contact address |
      |              |                 |

  @Preference @SettingsFunction
  Scenario: Preference Settings Function
    And user press settings function button "Preference"
    And user press back

  @Preference @SettingsFunction @ChangeTheme
  Scenario: Appearance Settings Function
    And user press settings function button "Preference"
    And user press button "Appearance"
    And user press button "Dark Yellow"
    And user press back

  @Preference @SettingsFunction @AccountIndention
  Scenario: Account Indention Settings Function
    And user press button "Account Indenticon"
    And user choose random image
    And user press back

  @Preference @SettingsFunction @Language
  Scenario: Language Settings Function
    And user press button "App Language"
    And user press button "Tiếng Việt"
    And user press button "English"
    And user press back

  @NetworkAppearance @SettingsFunction
  Scenario: Network Appearance Settings Function
    And user press settings function button "Network Appearance"
    And user press back

  @WalletConnect @SettingsFunction
  Scenario Outline: WalletConnect Settings Function
    And user press settings function button "WalletConnect"
    And user verify text on WalletConnect screen with title "<title>" and content "<content>"
    And user press button "New connection"
    And user press button "Close"
    Examples:
      | title         | content                                                             |
      | WalletConnect | Connect your wallet with WalletConnect to make transactions on DApp |

  @AirdropCode @SettingsFunction
  Scenario: Airdrop Code Settings Function
    And user press settings function button "Airdrop code"
    And user press back

  @AirdropCode @SettingsFunction
  Scenario Outline: Airdrop Code Settings Function
    And user press settings function button "Airdrop code"
    And user input airdrop code "<code>"
    And user press button "Submit"
    Then user verify popup title "<title>" content "<content>"
    Examples:
      | code | title | content |
      |      |       |         |
      |      |       |         |

  @Feedback @SettingsFunction
  Scenario: Feedback Settings Function
    And user press settings function button "Feedback"
    And user press back
    And user enter passcode "111111"

  @Security @SettingsFunction
  Scenario: Security Settings Function
    And user press settings function button "Security"
    And user enter passcode "111111"