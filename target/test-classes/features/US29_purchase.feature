@negative

Feature: Negative Scenario Purchasing with no info entered.

  @Test1
  Scenario: User can not purchase any items if there is no info on the Purchasing page.
    Given user is on the homepage of the application -trendgarden.net
    When user clicked on the Sepete Ekle button for an item
    And user goes to Sepetim button on the top right of the homepage
    And user clicks on the Satin Al button on the newly opening page
    And user enters nothing on the Purchasing page
    And user clicks on the Sonraki Adim button there
    Then user should not be able to proceed with next page