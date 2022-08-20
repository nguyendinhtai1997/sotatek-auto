@ReceiveFunc
Feature: Receive Func

  @ReceiveFunc @MainFunction
  Scenario Outline: Copy Address to Receive Token Function
    And user enter passcode "111111"
    And user press function button "Receive"
    And user press token "<token>" network "<network>"
    And user press button "Copy" to copy address
    Examples:
      | token | network |
      | BUSD  | BEP20   |

  @ReceiveFunc @MainFunction
  Scenario Outline: Verify Text Receive Screen
    Then verify receive title displayed "<title><token>"
    Then verify address displayed "<address>"
    Then verify guide text displayed "<guide>" of "<token>" "<network>"
    Examples:
      | title   | network | token | address                                    | guide                                                                                          |
      | Receive | BEP20   | BUSD  | 0x15F419C9F2a1Ae02A10c1bD517A5aCC71eb68463 | Only send to this address. Sending other cryptocurrencies to this address may cost you forever |

  @ReceiveFunc @MainFunction
  Scenario: Share Address to Receive Token Function
    And user press button "Share" to share address
    And user press back
    And user enter passcode "111111"