@positive

Feature: Positive Scenario After Completing the Purchase Steps With EFT option the user turns back to homepage

  @Test1
  Scenario: User turns back successfully to the Homepage after purchase with EFT section
    Given user is on the homepage of the application -trendgarden.net
    When user clicked on the Sepete Ekle button for an item
    And user goes to Sepetim button on the top right of the homepage
    And user clicks on the Satin Al button on the newly opening page
    And user enters required info for the Purchasing page
    And user clicks on the Sonraki Adim button there
    And user selects EFT option
    And user clicks on the Sonraki Adim button
    And user clicks on the Homepage button from the top left side of the newly opening page
    Then user should be able to turned back to the homepage successfully