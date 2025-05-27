@profile @runAll @smoke
Feature: User should be able to update the password that meets the minimum security requirements

  Background: Common Steps
    Given User is on the homepage
    When User Logins with valid credentials
    Then Navigate to the sifre degistirme page

  Scenario: US027 - TC01 User should be able to update the password that meets the minimum security requirements
    When Enter the correct current password to Mevcut Sifreniz
    When Enter a valid password to the Yeni Sifreniz
    Then Re-enter new password in the confirmation field Yeni Sifreniz Tekrar textbox
    And Click on Sifremi Degistir button
    Then Verify that the system displays a message on a pop up indicating that the password has changed
    And Log out from the account
    Then Login with the new password
    Then Verify logged in the account
    And Update new password to the old one